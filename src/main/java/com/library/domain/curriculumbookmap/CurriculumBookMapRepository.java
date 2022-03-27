package com.library.domain.curriculumbookmap;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * 커리큘럼-책 매핑 테이블 레포지토리
 */
public interface CurriculumBookMapRepository extends JpaRepository<CurriculumBookMap, Long> {
    List<Long> findByCurriculumId(Long curriculumId);
}
