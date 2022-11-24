package com.mao.uaa.util;

import com.google.common.collect.Sets;
import com.mao.uaa.config.JwtProperties;
import com.mao.uaa.domain.Role;
import com.mao.uaa.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static com.mao.uaa.util.Constants.ROLE_ADMIN;
import static com.mao.uaa.util.Constants.ROLE_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author myseital
 * @date 2022/9/27
 */
@ExtendWith(SpringExtension.class)
public class JwtUtilUnitTests {

    private JwtUtil jwtUtil;
    private JwtProperties jwtProperties;

    @BeforeEach
    public void setup() {
        jwtProperties = new JwtProperties();
        jwtUtil = new JwtUtil(jwtProperties);
    }

    @Test
    public void givenUserDetails_thenCreateTokenSuccess() {
        String username = "user";
        Set<Role> authorities = Sets.newHashSet(
                Role.builder()
                        .authority(ROLE_USER)
                        .build(),
                Role.builder()
                        .authority(ROLE_ADMIN)
                        .build());
        User user = User.builder()
                .username(username)
                .authorities(authorities)
                .build();
        // 创建 jwt
        String token = jwtUtil.createAccessToken(user);
        // 解析
        Claims parsedClaims = Jwts.parserBuilder()
                .setSigningKey(JwtUtil.key).build()
                .parseClaimsJws(token).getBody();
        // subject 和 username 应该相同
        assertEquals(username, parsedClaims.getSubject(), "解析 Subject 后，应是用户名");
//        // 解析后的角色列表
//        List<?> parsedAuthorities = CollectionUtil.convertObjectToList(parsedClaims.get("authorities"));
//        // 将原始的 Role 转换为字符串的角色名称列表
//        List<String> expectedAuthorities = authorities.stream().map(Role::getAuthority).collect(Collectors.toList());
//        assertEquals(expectedAuthorities, parsedAuthorities);
//        String refreshToken = jwtUtil.createRefreshToken(user);
//        Optional<Claims> parsedClaimsFromRefreshToken = jwtUtil.parseClaims(refreshToken, JwtUtil.refreshKey);
//        assertTrue(parsedClaimsFromRefreshToken.isPresent());
//        assertTrue(parsedClaimsFromRefreshToken.get().getExpiration().getTime() < System.currentTimeMillis() + appProperties.getJwt().getRefreshTokenExpireTime());
//        assertTrue(parsedClaimsFromRefreshToken.get().getExpiration().getTime() > System.currentTimeMillis() + appProperties.getJwt().getRefreshTokenExpireTime() - 1000L);
//        String accessTokenWithRefreshToken = jwtUtil.buildAccessTokenWithRefreshToken(refreshToken);
//        Optional<Claims>  parsedClaimsFromAccessToken = jwtUtil.parseClaims(accessTokenWithRefreshToken, JwtUtil.key);
//        assertTrue(parsedClaimsFromAccessToken.isPresent());
//        assertTrue(parsedClaimsFromAccessToken.get().getExpiration().getTime() < System.currentTimeMillis() + appProperties.getJwt().getAccessTokenExpireTime());
//        assertTrue(parsedClaimsFromAccessToken.get().getExpiration().getTime() > System.currentTimeMillis() + appProperties.getJwt().getAccessTokenExpireTime() - 1000L);
    }
}
