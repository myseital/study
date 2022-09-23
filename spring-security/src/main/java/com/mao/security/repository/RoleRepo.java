package com.mao.security.repository;

import com.mao.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author myseital
 * @date 2022/9/16
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
