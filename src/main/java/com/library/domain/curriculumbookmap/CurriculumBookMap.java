package com.library.domain.curriculumbookmap;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class CurriculumBookMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long curriculumId;

    @Column(nullable = false)
    private Long bookId;

    @Builder
    public CurriculumBookMap(Long id, Long curriculumId, Long bookId) {
        this.id = id;
        this.curriculumId = curriculumId;
        this.bookId = bookId;
    }
}
