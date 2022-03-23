package com.library.web.dto;

import com.library.domain.books.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
public class BookDto {
    private Long id;
    private String isbn13;
    private String isbn10;
    private LocalDate publicationDate;
    private String desc;
    private String category;
    private Long parentId;

    @Builder
    public BookDto(String isbn13, String isbn10, LocalDate publicationDate, String desc, String category, Long parentId) {
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.publicationDate = publicationDate;
        this.desc = desc;
        this.category = category;
        this.parentId = parentId;
    }

    public Book toEntity(){
        return Book.builder()
                .isbn10(this.isbn10)
                .isbn13(this.isbn13)
                .publicationDate(this.publicationDate)
                .desc(this.desc)
                .build();
    }
}
