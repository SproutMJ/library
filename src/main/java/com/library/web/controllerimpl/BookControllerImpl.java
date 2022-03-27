package com.library.web.controllerimpl;

import com.library.serviceimpl.BookServiceImpl;
import com.library.web.controller.BookController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * 책 컨트롤러 레이어 구현체
 */
@RequiredArgsConstructor
@Controller
public class BookControllerImpl implements BookController {
    private final BookServiceImpl bookServiceImpl;

    @GetMapping("/search")
    @Override
    public String search(HttpServletRequest req){

        return "search";
    }


}
