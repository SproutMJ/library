package com.library.serviceimpl;

import com.library.domain.user.Users;
import com.library.domain.user.UsersRepository;
import com.library.service.LoginService;
import com.library.web.dto.LoginFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UsersRepository usersRepository;

    @Transactional
    public Users login(LoginFormDto form){
        try{
            Users user = usersRepository.findByLoginIdAndPassword(form.getId(), form.getPassword());
            return user;
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    public boolean register(Users user){
        try{
            usersRepository.save(user);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}