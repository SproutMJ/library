package com.library.serviceimpl;

import com.library.domain.books.Book;
import com.library.domain.books.BookRepository;
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

@RequiredArgsConstructor
@Service
public class BookServiceImpl {
    public final BookRepository bookRepository;

    private static String clientID = "8OgLifq3mDuwMOJhVmWB"; //api 사용 신청시 제공되는 아이디
    private static String clientSecret = "Q9kNhTJyS1"; //패스워드

    @Transactional
    List<Book> searchBookByNaver(String name){
        List<Book> books = null;
        try {
            name = URLEncoder.encode(name);
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
            for (int i=0; i<size; i++){
                JSONObject o = (JSONObject) array.get(i);

                books.add(Book.builder().title((String) o.get("title"))
                        .detailLink((String) o.get("link")).imageLink((String) o.get("image"))
                        .author((String) o.get("author")).publisher((String) o.get("publisher"))
                        .isbn13((String) o.get("isbn")).desc((String) o.get("desc"))
                        .publicationDate(LocalDate.parse((String)o.get("pubdate"), DateTimeFormatter.ofPattern("yyyyMMdd"))).build());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Transactional
    boolean register(List<Book> books){
        try{
            for (Book b: books){
                bookRepository.save(b);
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
