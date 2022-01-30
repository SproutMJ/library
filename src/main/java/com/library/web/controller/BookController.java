package com.library.web.controller;

import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping("/user")
    String user(){
        return "user";
    }

    @GetMapping("/search")
    String search(){
        return "search";
    }

    @GetMapping("/curriculum")
    String curriculum(){
        return "curriculum";
    }

    @GetMapping("/progress")
    String progress(){
        return "progress";
    }

    @GetMapping("/register")
    String register(){
        return "register";
    }
}
