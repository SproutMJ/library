package com.library.web.controllerimpl;

import com.library.domain.user.Users;
import com.library.web.dto.LoginFormDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerImplTest {
    @Autowired
    LoginControllerImpl controller;

    @Mock
    private BindingResult mockBindingResult = Mockito.mock(BindingResult.class);
    @Mock
    private HttpServletRequest mockHttpRequest = Mockito.mock(HttpServletRequest.class);
    @Mock
    private HttpSession mockHttpSession = Mockito.mock(HttpSession.class);

    @Before
    public void testPrepare(){
        when(mockHttpRequest.getSession()).thenReturn(mockHttpSession);
        controller.register(Users.builder().id("test").password("test").firstName("gildong").lastName("hong").registeredDate(LocalDate.now()).build(), mockBindingResult);
    }

//    @Test
//    public void registerPrepare(){
//        controller.register(Users.builder().id("test").password("test").firstName("gildong").lastName("hong").registeredDate(LocalDate.now()).build(), mockBindingResult);
//    }

    @Test
    public void logoutTest(){

    }

    @Test
    public void loginTest(){
        controller.login(new LoginFormDto("test", "test"), mockBindingResult, "/", mockHttpRequest);


    }


}
