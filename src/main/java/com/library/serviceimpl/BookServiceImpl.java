package com.library.serviceimpl;

import com.library.domain.books.Book;
import com.library.domain.books.BookRepository;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * 책 서비스 레이어 구현체
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    public final BookRepository bookRepository;

    private static String clientID = "8OgLifq3mDuwMOJhVmWB"; //api 사용 신청시 제공되는 아이디
    private static String clientSecret = "Q9kNhTJyS1"; //패스워드

    @Transactional
    @Override
    public List<Book> searchBookByNaver(String name){
        List<Book> books = null;
        try {
            name = URLEncoder.encode(name, "UTF-8");
            URL url = new URL("https://openapi.naver.com/v1/search/book.json?query=" + name);
            URLConnection con;
            con = url.openConnection();
            con.setRequestProperty("X-Naver-Client-Id", clientID);
            con.setRequestProperty("X-naver-Client-Secret", clientSecret);

            InputStream stream = con.getInputStream();
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(new InputStreamReader(stream, "UTF-8"));

            JSONArray array = (JSONArray) object.get("items");
            books = new ArrayList<>();

            long size = array.size();
            System.out.println(size);
            for (int i=0; i<size; i++){
                JSONObject o = (JSONObject) array.get(i);
                String[] isbn = ((String)o.get("isbn")).split(" ");
                String isbn10, isbn13;
                if(isbn[0].length() == 10){
                    isbn10 = isbn[0];
                    isbn13 = isbn[1];
                }else{
                    isbn10 = isbn[1];
                    isbn13 = isbn[0];
                }

                books.add(Book.builder().title((String) o.get("title"))
                        .detailLink((String) o.get("link")).imageLink((String) o.get("image"))
                        .author((String) o.get("author")).publisher((String) o.get("publisher"))
                        .isbn10(isbn10).isbn13(isbn13).desc((String) o.get("desc"))
                        .publicationDate(LocalDate.parse((String)o.get("pubdate"), DateTimeFormatter.ofPattern("yyyyMMdd"))).build());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {

        }
        return books;
    }

    @Transactional
    @Override
    public boolean register(Book book){
        try{
            bookRepository.save(book);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
