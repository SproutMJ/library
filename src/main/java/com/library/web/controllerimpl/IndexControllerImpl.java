package com.library.web.controllerimpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControllerImpl {

    @GetMapping("/")
    public String index(){
        return "<h1>index</h1>";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
