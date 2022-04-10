package com.library.service;

import com.library.domain.user.Users;
import org.springframework.stereotype.Service;

/*
 * 유저 서비스 레이어 인터페이스
 */
@Service
public interface UserService {
    Users findByLoginIdAndPassword(String loginId, String password);
}
