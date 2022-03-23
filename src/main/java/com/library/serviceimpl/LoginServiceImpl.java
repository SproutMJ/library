package com.library.serviceimpl;

import com.library.domain.user.Users;
import com.library.domain.user.UsersRepository;
import com.library.web.dto.LoginForm;
import com.library.web.dto.LoginFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl {
    private final UsersRepository usersRepository;

    public Users login(LoginFormDto form){
        Users user = usersRepository.findById(form.getId()).get();
        if(user.getPassword().equals(form.getPassword())) return user;
        else return null;
    }

    public boolean register(Users user){
        if(usersRepository.findById(user.getId()).isPresent()) return false;
        usersRepository.save(user);
        return true;
    }
}