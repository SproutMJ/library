package com.library.web.controllerimpl;


import com.library.domain.books.Book;
import com.library.domain.books.BookRepository;
import com.library.domain.curriculum.Curriculum;
import com.library.domain.curriculumbookmap.CurriculumBookMapRepository;
import com.library.domain.progress.Progress;
import com.library.domain.progress.ProgressRepository;
import com.library.service.CurriculumService;
import com.library.web.controller.UserController;
import com.library.web.dto.BookDto;
import com.library.web.dto.CurriculumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 * 유저 컨트롤러 레이어 구현체
 */
@RequiredArgsConstructor
@Controller
public class UserControllerImpl implements UserController {
    private CurriculumService curriculumService;
    private CurriculumBookMapRepository curriculumBookMapRepository;
    private BookRepository bookRepository;
    private ProgressRepository progressRepository;

    @GetMapping("/curriculum")
    @Override
    public String curriculum(HttpServletRequest req){
        Long userID = (Long) req.getSession().getAttribute("id");
        List<Curriculum> curriculums = curriculumService.retrieveByUserId(userID);
        List<CurriculumDto> curriculumDtos = null;
        for (Curriculum c : curriculums){
            Long curId = c.getId();
            List<BookDto> bookDtos = null;
            List<Long> booksId = curriculumBookMapRepository.findByCurriculumId(curId);
            for (Long b : booksId){
                Book book = bookRepository.getById(b);
                Progress progress = progressRepository.findByUserIdAndBookId(userID, book.getId());
                BookDto bookDto = BookDto.builder().book(book).progress(progress).build();
                bookDtos.add(bookDto);
            }
            CurriculumDto curriculumDto = CurriculumDto.builder().curriculum(c).books(bookDtos).build();
            curriculumDtos.add(curriculumDto);
        }

        req.setAttribute("curriculums", curriculumDtos);
        return "curriculum";
    }

    @GetMapping("/register")
    @Override
    public String register(HttpServletRequest req){
        return "register";
    }
}
