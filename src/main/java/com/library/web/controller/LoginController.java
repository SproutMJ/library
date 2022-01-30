package com.library.web.controller;

import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final UserService userService;

    @GetMapping(value = "login.do", produces = "application/json; charset=utf8")
    public String loginDo(@RequestParam("id") String id, @RequestParam("password") String password){
        return "already";
    }
}
