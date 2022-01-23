package com.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller

@RestController
public class Controller {
    @GetMapping("/")
    String index(){
        return "index";
    }
    @GetMapping("/user")
    String user(){
        return "user";
    }
    @GetMapping("/config")
    String config(){
        return "config";
    }
}
