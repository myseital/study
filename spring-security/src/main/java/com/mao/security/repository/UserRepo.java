package com.mao.security.repository;

import com.mao.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author myseital
 * @date 2022/9/16
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findOptionalByUsername(String username);
}
