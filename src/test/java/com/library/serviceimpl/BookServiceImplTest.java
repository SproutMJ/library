package com.library.serviceimpl;

import com.library.domain.books.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    BookServiceImpl bookServiceImpl;


    @Test
    public void searchTest(){
        List<Book> books =  bookServiceImpl.searchBookByNaver("Do it! HTML+CSS+자바스크립트 웹 표준의 정석");
        for (Book b : books){
            System.out.println(b.toString());
        }
    }
    @Test
    public void saveTest(){
        Book b = bookServiceImpl.searchBookByNaver("자바").get(0);
        bookServiceImpl.register(b);
        bookServiceImpl.register(b);
    }
    @Test
    public void progTest(){

    }
}
