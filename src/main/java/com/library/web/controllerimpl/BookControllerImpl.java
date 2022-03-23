package com.library.web.controllerimpl;

import com.library.serviceimpl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BookControllerImpl {
    private final BookServiceImpl bookServiceImpl;

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
