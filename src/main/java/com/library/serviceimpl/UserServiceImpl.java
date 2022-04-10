package com.library.serviceimpl;

import com.library.domain.user.Users;
import com.library.domain.user.UsersRepository;
import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
 * 유저 서비스 레이어 구현체
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Transactional
    public Users findByLoginIdAndPassword(String loginId, String password){
        return usersRepository.findByLoginIdAndPassword(loginId, password);
    }
}
