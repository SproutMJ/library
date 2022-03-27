package com.library.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 책 레포지토리
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
