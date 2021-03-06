package com.library.web.controller;

import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * 유저 컨트롤러 레이어 인터페이스
 */
@Controller
public interface UserController {
    @GetMapping("/curriculum")
    String curriculum(HttpServletRequest req, Model model);

    @GetMapping("/register")
    String register(HttpServletRequest req);
}
