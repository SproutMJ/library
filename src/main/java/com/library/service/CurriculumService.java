package com.library.service;

import com.library.domain.books.Book;
import com.library.domain.curriculum.Curriculum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurriculumService {
    public boolean register(Curriculum curriculum);
    public boolean registerBook(Curriculum curriculum, Book book);
    public List<Curriculum> retrieveByUserId(Long userId);
}
