package com.library.web.dto;

import com.library.domain.curriculum.Curriculum;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/*
 * 컨트롤러 Dto
 */
@Getter
public class CurriculumDto {
    private Curriculum curriculum;
    private List<BookDto> books;

    @Builder
    public CurriculumDto(Curriculum curriculum, List<BookDto> books) {
        this.curriculum = curriculum;
        this.books = books;
    }
}
