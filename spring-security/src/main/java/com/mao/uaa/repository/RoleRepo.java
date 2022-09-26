package com.mao.uaa.repository;

import com.mao.uaa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * @author myseital
 * @date 2022/9/16
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Set<Role> findByAuthorityIn(Set<String> authority);

    Optional<Role> findOptionalByAuthority(String authority);
}
