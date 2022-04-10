package com.library.web.controller;

import com.library.domain.user.Users;
import com.library.web.dto.LoginFormDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/*
 * 로그인 컨트롤러 레이어 인터페이스
 */
public interface LoginController {
    String loginForm();
    String registerForm();
    String login(@ModelAttribute @Validated LoginFormDto loginForm,
                 @RequestParam(defaultValue = "/") String redirectURL,
                 HttpServletRequest request);
    String logout(HttpServletRequest request);
    String register(HttpServletRequest request);

}
