package com.library.domain.progress;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 책 진행도 레포지토리
 */
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Progress findByUserIdAndBookId(Long userId, Long bookId);
}
