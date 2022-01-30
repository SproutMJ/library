package com.library.service;

import com.library.domain.books.BookRepository;
import com.library.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BookService {
    public final BookRepository bookRepository;

    @Transactional
    public Long register(BookDto bookDto){
        return bookDto.toEntity().getId();
    }
}
