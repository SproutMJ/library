package com.library.domain.books;

import com.library.domain.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Book extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 13, nullable = false)
    private String isbn13;

    @Column(length = 10, nullable = false)
    private String isbn10;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(length = 100, nullable = false)
    private String desc;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(nullable = false)
    private Long parentId;

    @Builder
    public Book(String isbn13, String isbn10, LocalDate publicationDate, String desc, String category, Long parentId) {
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.publicationDate = publicationDate;
        this.desc = desc;
        this.category = category;
        this.parentId = parentId;
    }
}
