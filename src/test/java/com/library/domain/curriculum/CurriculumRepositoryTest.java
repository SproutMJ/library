package com.library.domain.curriculum;

import com.library.domain.user.Users;
import com.library.service.LoginService;
import com.library.web.dto.LoginFormDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumRepositoryTest {
    @Autowired
    private CurriculumRepository curriculumRepository;
    @Autowired
    private LoginService loginService;

    @Before
    public void init(){
        loginService.register(Users.builder().loginId("test").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
    }

    @Test
    public void register(){
        Users user = loginService.login(new LoginFormDto("test", "ptest"));
        curriculumRepository.save(Curriculum.builder().userId(user.getId()).name("커리큘럼1").regDate(LocalDate.now()).build());
        List<Curriculum> curriculums = curriculumRepository.findByUserId(user.getId());

        assertThat(curriculums.get(0).getName()).isEqualTo("커리큘럼1");
    }
}