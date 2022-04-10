package com.library.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * 로그인 폼 Dto
 */
@Data
@RequiredArgsConstructor
public class LoginFormDto {
    String id;
    String password;

    @Builder
    public LoginFormDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
