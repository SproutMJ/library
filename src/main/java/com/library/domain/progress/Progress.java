package com.library.domain.progress;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/*
 * 책 진행도 엔티티
 */
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = true)
    private Double progress;


    @Builder
    public Progress(Long id, Long userId, Long bookId, Double progress) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.progress = progress;
    }
}
