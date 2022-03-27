package com.library.serviceimpl;

import com.library.domain.user.Users;
import com.library.domain.user.UsersRepository;
import com.library.service.LoginService;
import com.library.web.dto.LoginFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
 * 로그인 서비스 레이어 구현체
 */
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UsersRepository usersRepository;

    @Transactional
    @Override
    public Users login(LoginFormDto form){
        try{
            Users user = usersRepository.findByLoginIdAndPassword(form.getId(), form.getPassword());
            return user;
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    @Override
    public boolean register(Users user){
        try{
            usersRepository.save(user);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}