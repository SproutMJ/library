package com.library.domain.books;

import com.library.domain.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class Book extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 128, nullable = true)
    private String detailLink;

    @Column(length = 128, nullable = true)
    private String imageLink;

    @Column(length = 64, nullable = true)
    private String author;

    @Column(length = 64, nullable = true)
    private String publisher;

    @Column(length = 13, nullable = true)
    private String isbn13;

    @Column(length = 10, nullable = true)
    private String isbn10;

    @Column(length = 100, nullable = true)
    private String desc;

    @Column(nullable = true)
    private LocalDate publicationDate;

    @Builder
    public Book(Long id, String title, String detailLink, String imageLink, String author, String publisher, String isbn13, String isbn10, String desc, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.detailLink = detailLink;
        this.imageLink = imageLink;
        this.author = author;
        this.publisher = publisher;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.desc = desc;
        this.publicationDate = publicationDate;
    }
}
