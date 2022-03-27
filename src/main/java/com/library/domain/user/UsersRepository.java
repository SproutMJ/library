package com.library.domain.user;

import com.library.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 유저 레포지토리
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByLoginIdAndPassword(String loginId, String password);
}
