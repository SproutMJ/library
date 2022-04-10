package com.library.serviceimpl;

import com.library.domain.books.Book;
import com.library.domain.curriculum.Curriculum;
import com.library.domain.curriculum.CurriculumRepository;
import com.library.domain.curriculumbookmap.CurriculumBookMap;
import com.library.domain.curriculumbookmap.CurriculumBookMapRepository;
import com.library.domain.progress.Progress;
import com.library.domain.progress.ProgressRepository;
import com.library.domain.user.Users;
import com.library.service.BookService;
import com.library.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
 * 커리큘럼 서비스 레이어 구현체
 */
@RequiredArgsConstructor
@Service
public class CurriculumServiceImpl implements CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final BookService bookService;
    private final CurriculumBookMapRepository curriculumBookMapRepository;
    private final ProgressRepository progressRepository;

    @Transactional
    @Override
    public boolean register(Curriculum curriculum){
        try{
            curriculumRepository.save(curriculum);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean registerBook(Users user, Curriculum curriculum, Book book) {
        try{
            bookService.register(book);
            curriculumBookMapRepository.save(CurriculumBookMap.builder().curriculumId(curriculum.getId()).bookId(book.getId()).build());
            progressRepository.save(Progress.builder().userId(user.getId()).bookId(book.getId()).build());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public List<Curriculum> retrieveByUserId(Long userId){
        return curriculumRepository.findByUserId(userId);
    }
}
