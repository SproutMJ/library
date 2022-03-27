package com.library.web.dto;

import com.library.domain.books.Book;
import com.library.domain.progress.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/*
 * 책 Dto
 */
@Getter
public class BookDto {
    private Book book;
    private Progress progress;

    @Builder
    public BookDto(Book book, Progress progress) {
        this.book = book;
        this.progress = progress;
    }
}
