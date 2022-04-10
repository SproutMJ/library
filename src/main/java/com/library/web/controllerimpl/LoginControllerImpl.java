package com.library.web.controllerimpl;

import com.library.domain.user.Users;
import com.library.service.LoginService;
import com.library.service.UserService;
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
import java.time.LocalDate;

/*
 * 로그인 컨트롤러 레이어 구현체
 */
@RequiredArgsConstructor
@Controller
public class LoginControllerImpl implements LoginController {
    private final UserService userServiceqnImpl;
    private final LoginService loginServiceImpl;

    @GetMapping(value = "/login/loginForm")
    @Override
    public String loginForm(){
        return "loginForm";
    }

    @Override
    @GetMapping(value = "/login/registerForm")
    public String registerForm() {
        return "registerForm";
    }

    @PostMapping(value = "/login/login.do")
    @Override
    public String login(@ModelAttribute @Validated LoginFormDto loginForm,
                        @RequestParam(name = "redirect", defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {
       //if(bindingResult.hasErrors()) return "/login/loginForm";

        System.out.println(loginForm.getId());
        Users user = loginServiceImpl.login(loginForm);
        //System.out.println(user.toString());
        if(user == null) {
            System.out.println("실패");
            //bindingResult.reject("loginFail", "로그인 실패");
            return "loginForm";
        }

        System.out.println(user.getId());
        //세션 만료시간 추가 필요
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());

        return "redirect:" + redirectURL;
    }

    @PostMapping(value = "/login/logout.do")
    @Override
    public String logout(HttpServletRequest request) {
        if(request.getSession(false) != null)
            request.getSession(false).invalidate();;

            return "redirect:/";
    }

    @PostMapping(value="/login/register.do")
    @Override
    public String register(HttpServletRequest request){
        Users user = Users.builder()
                .firstName(request.getParameter("first-name"))
                .lastName(request.getParameter("last-name"))
                .registeredDate(LocalDate.now())
                .loginId(request.getParameter("id"))
                .password(request.getParameter("password"))
                .build();

        if(!loginServiceImpl.register(user)) {
            //bindingResult.reject("registerFail", "회원가입 실패");
            return "login/loginFail";
        }
        return "redirect:/login/loginForm";
    }
}