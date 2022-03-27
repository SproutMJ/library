package com.library.service;

import com.library.domain.books.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 책 서비스 레이어 인터페이스
 */
@Service
public interface BookService {
    List<Book> searchBookByNaver(String name);
    boolean register(Book book);
}
