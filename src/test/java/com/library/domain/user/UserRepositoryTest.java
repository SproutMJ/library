package com.library.domain.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired UsersRepository usersRepository;

    @After
    public void deleteAll(){
        usersRepository.deleteAll();;
    }

    @Before
    public void preRegistering(){
        usersRepository.save(Users.builder().loginId("test").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
    }

    @Test
    public void register(){
        usersRepository.save(Users.builder().loginId("test2").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
        Users user = usersRepository.findByLoginIdAndPassword("test2", "ptest");
        System.out.println(user.toString());
        assertThat(user.getFirstName()).isEqualTo("이름");
    }

    @Test
    public void findUser(){
        Users user = usersRepository.findByLoginIdAndPassword("test", "pest");
        assertNotNull(user);
    }

}
