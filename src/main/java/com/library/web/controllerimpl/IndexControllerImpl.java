package com.library.web.controllerimpl;

import com.library.web.controller.IndexController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 랜딩페이지 컨트롤러 레이어 구현체
 */
@Controller
public class IndexControllerImpl implements IndexController {

    @GetMapping("/")
    public String index(){
        return "<h1>index</h1>";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
