package com.library.domain.curriculum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * 커리큘럼 레포지토리
 */
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    List<Curriculum> findByUserId(Long userId);
}
