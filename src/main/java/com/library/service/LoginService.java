package com.library.service;

import com.library.domain.user.Users;
import com.library.web.dto.LoginFormDto;
import org.springframework.stereotype.Service;

/*
 * 로그인 서비스 레이어 인터페이스
 */
@Service
public interface LoginService {
    Users login(LoginFormDto form);
    boolean register(Users user);
}
