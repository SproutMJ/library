package com.library.web.controllerimpl;

import com.library.domain.user.Users;
import com.library.serviceimpl.LoginServiceImpl;
import com.library.serviceimpl.UserServiceImpl;
import com.library.web.controller.LoginController;
import com.library.web.dto.LoginFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * 로그인 컨트롤러 레이어 구현체
 */
@RequiredArgsConstructor
@Controller
public class LoginControllerImpl implements LoginController {
    private final UserServiceImpl userServiceImpl;
    private final LoginServiceImpl loginServiceImpl;

    @GetMapping(value = "/loginFrom")
    @Override
    public String loginForm(){
        return "login/loginForm";
    }

    @PostMapping(value = "/login")
    @Override
    public String login(@ModelAttribute @Validated LoginFormDto loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {
       if(bindingResult.hasErrors()) return "login/loginForm";

       Users user = loginServiceImpl.login(loginForm);
        if(user == null) {
            bindingResult.reject("loginFail", "로그인 실패");
            return "login/loginForm";
        }

        //세션 만료시간 추가 필요
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());

        return "redirect:" + redirectURL;
    }

    @PostMapping(value = "/logout")
    @Override
    public String logout(HttpServletRequest request) {
        if(request.getSession(false) != null)
            request.getSession(false).invalidate();;

            return "redirect:/";
    }

    @PostMapping(value="/register")
    @Override
    public String register(HttpServletRequest request, BindingResult bindingResult){
        //로그인 폼 제작 이후 구현
//        if(loginServiceImpl.register(user)) {
//            bindingResult.reject("registerFail", "회원가입 실패");
//            return "login/loginFail";
//        }
        return "login/loginSuccess";
    }
}