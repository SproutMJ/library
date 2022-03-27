package com.library.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * 책 컨트롤러 레이어 인터페이스
 */
public interface BookController {
    @GetMapping("/search")
    String search(HttpServletRequest req);


}
