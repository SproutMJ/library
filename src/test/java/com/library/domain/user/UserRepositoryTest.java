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
        usersRepository.save(Users.builder().id("test").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
    }

    @Test
    public void register(){
        usersRepository.save(Users.builder().id("itest").password("ptest").firstName("이름").lastName("성").registeredDate(LocalDate.now()).build());
        List<Users> users = usersRepository.findAll();
        Users user = users.get(0);
        assertThat(user.getFirstName()).isEqualTo("이름");
    }

    @Test
    public void findUser(){
        Optional<Users> user = usersRepository.findById("test");
        assertThat(user).isNotEqualTo(Optional.empty());
    }

}
