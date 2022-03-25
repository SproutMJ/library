package com.library.serviceimpl;

import com.library.domain.books.Book;
import com.library.domain.curriculum.Curriculum;
import com.library.domain.curriculum.CurriculumRepository;
import com.library.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CurriculumServiceImpl implements CurriculumService {
    private CurriculumRepository curriculumRepository;

    @Transactional
    public boolean register(Curriculum curriculum){
        try{
            curriculumRepository.save(curriculum);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean registerBook(Curriculum curriculum, Book book) {
        return false;
    }

    @Transactional
    public List<Curriculum> retrieveByUserId(Long userId){
        return curriculumRepository.findByUserId(userId);
    }
}
