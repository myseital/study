package com.mao.uaa.service;

import com.google.common.collect.Sets;
import com.mao.uaa.domain.Auth;
import com.mao.uaa.domain.User;
import com.mao.uaa.repository.RoleRepo;
import com.mao.uaa.repository.UserRepo;
import com.mao.uaa.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mao.uaa.util.Constants.ROLE_USER;

/**
 * @author myseital
 * @date 2022/9/26
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    /**
     * 注册一个新用户
     *
     * @param user 用户实体
     * @return 保存后的对象
     */
    @Transactional
    public User register(User user) {
        return roleRepo.findOptionalByAuthority(ROLE_USER)
                .map(role -> {
                    User userToSave = user
                            .withAuthorities(Sets.newHashSet(role))
                            .withPassword(passwordEncoder.encode(user.getPassword()));
                    return userRepo.save(userToSave);
                })
                .orElseThrow(() -> new RuntimeException("注册新用户失败"));
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return JWT
     */
    public Auth login(String username, String password) {
        return userRepo.findOptionalByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> new Auth(jwtUtil.createAccessToken(user), jwtUtil.createRefreshToken(user)))
                .orElseThrow(() -> new AccessDeniedException("用户名密码错误"));
    }

    /**
     * 取得全部用户列表
     *
     * @return 全部用户列表
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 存在与否
     */
    public boolean isUsernameExisted(String username) {
        return userRepo.countByUsername(username) > 0;
    }

    /**
     * 判断电邮地址是否存在
     *
     * @param email 电邮地址
     * @return 存在与否
     */
    public boolean isEmailExisted(String email) {
        return userRepo.countByEmail(email) > 0;
    }

    /**
     * 判断手机号是否存在
     *
     * @param mobile 手机号
     * @return 存在与否
     */
    public boolean isMobileExisted(String mobile) {
        return userRepo.countByMobile(mobile) > 0;
    }
}
