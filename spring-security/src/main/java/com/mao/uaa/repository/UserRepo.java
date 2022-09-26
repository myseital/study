package com.mao.uaa.repository;

import com.mao.uaa.domain.User;
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

    long countByUsername(String username);

    long countByEmail(String email);

    long countByMobile(String mobile);
}
