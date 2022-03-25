package com.library.serviceimpl;

import com.library.domain.user.Users;
import com.library.domain.user.UsersRepository;
import com.library.service.LoginService;
import com.library.web.dto.LoginFormDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UsersRepository usersRepository;
    @After
    public void deleteAll(){
        usersRepository.deleteAll();
    }

    @Test
    public void registerAndLoginTest(){
        loginService.register(Users.builder().loginId("test").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
        assertThat(loginService.login(new LoginFormDto("test", "ptest")).getFirstName()).isEqualTo("이름");
    }
}
