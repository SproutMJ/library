package com.library.web.controllerimpl;

import com.library.domain.user.Users;
import com.library.serviceimpl.LoginServiceImpl;
import com.library.serviceimpl.UserServiceImpl;
import com.library.web.dto.LoginFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginControllerImpl {
    private final UserServiceImpl userServiceImpl;
    private final LoginServiceImpl loginServiceImpl;

    @GetMapping(value = "/loginFrom")
    public String loginForm(){
        return "login/loginForm";
    }

    @PostMapping(value = "/login")
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
    public String logout(HttpServletRequest request) {
        if(request.getSession(false) != null)
            request.getSession(false).invalidate();;

            return "redirect:/";
    }

    @PostMapping(value="/register")
    public String register(@RequestBody Users user, BindingResult bindingResult){
        if(loginServiceImpl.register(user)) {
            bindingResult.reject("registerFail", "회원가입 실패");
            return "login/loginFail";
        }

        return "login/loginSuccess";
    }
}