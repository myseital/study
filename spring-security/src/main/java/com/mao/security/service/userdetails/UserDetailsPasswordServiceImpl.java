package com.mao.security.service.userdetails;

import com.mao.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author myseital
 * @date 2022/9/16
 */
@Service
@RequiredArgsConstructor
public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {

    private final UserRepo userRepo;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return userRepo.findOptionalByUsername(user.getUsername())
                .map(userFromDb -> userRepo.save(userFromDb.withPassword(newPassword)))
                .orElseThrow(() -> new RuntimeException("更新密码失败"));

    }
}
