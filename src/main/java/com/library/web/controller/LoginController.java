package com.library.web.controller;

import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final UserService userService;

    @PostMapping(value = "login.do")
    public String loginDo(@RequestBody HashMap<String, String> idPassword){
        return "already";
    }
}