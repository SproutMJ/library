package com.library.service;

import com.library.domain.books.Book;
import com.library.domain.curriculum.Curriculum;
import com.library.domain.user.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 커리큘럼 레이어 인터페이스
 */
@Service
public interface CurriculumService {
    boolean register(Curriculum curriculum);
    boolean registerBook(Users user, Curriculum curriculum, Book book);
    List<Curriculum> retrieveByUserId(Long userId);
}
