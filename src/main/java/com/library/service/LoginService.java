package com.library.service;

import com.library.domain.user.Users;
import com.library.web.dto.LoginFormDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public Users login(LoginFormDto form);
    public boolean register(Users user);
}
