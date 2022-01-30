package com.library.domain.book;

import com.library.domain.books.Book;
import com.library.domain.books.BookRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @After
    public void clean(){
        bookRepository.deleteAll();
    }

    @Test
    public void callBook(){
        bookRepository.save(Book.builder().isbn10("10").isbn13("13").category("science").desc("temp").parentId(0L).publicationDate(Date.from(Instant.now())).build());
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertThat(book.getIsbn10()).isEqualTo("10");
    }
}
