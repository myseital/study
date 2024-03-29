package com.mao.uaa.util;

import com.mao.uaa.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author myseital
 * @date 2022/9/26
 */
@RequiredArgsConstructor
@Component
public class JwtUtil {

    /**
     * 用于签名 Access Token
     */
    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    /**
     * 用于签名 Refresh Token
     */
    public static final Key refreshKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private final JwtProperties jwtProperties;

    public String createAccessToken(UserDetails userDetails) {
        return createJWTToken(userDetails, jwtProperties.getJwt().getAccessTokenExpireTime());
    }

    public String createJWTToken(UserDetails userDetails, long timeToExpire) {
        return createJWTToken(userDetails, timeToExpire, key);
    }

    public String createRefreshToken(UserDetails userDetails) {
        return createJWTToken(userDetails, jwtProperties.getJwt().getRefreshTokenExpireTime(), refreshKey);
    }

    /**
     * 根据用户信息生成一个 JWT
     *
     * @param userDetails  用户信息
     * @param timeToExpire 毫秒单位的失效时间
     * @param signKey      签名使用的 key
     * @return JWT
     */
    public String createJWTToken(UserDetails userDetails, long timeToExpire, Key signKey) {
        return Jwts
                .builder()
                .setId("uaa")
                .setSubject(userDetails.getUsername())
                .claim("authorities", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + timeToExpire))
                .signWith(signKey, SignatureAlgorithm.HS512).compact();
    }

    public boolean validateAccessToken(String jwtToken) {
        return validateToken(jwtToken, key);
    }

    public boolean validateRefreshToken(String jwtToken) {
        return validateToken(jwtToken, refreshKey);
    }

    public boolean validateToken(String jwtToken, Key signKey) {
        try {
            Jwts.parserBuilder().setSigningKey(JwtUtil.key).build().parseClaimsJws(jwtToken);
            return true;
        } catch (ExpiredJwtException | SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String buildAccessTokenWithRefreshToken(String jwtToken) {
        return parseClaims(jwtToken, refreshKey)
                .map(claims -> Jwts.builder()
                        .setClaims(claims)
                        .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getJwt().getAccessTokenExpireTime()))
                        .signWith(key, SignatureAlgorithm.HS512).compact())
                .orElseThrow(() -> new RuntimeException("retrieve access token error"));
    }

    public Optional<Claims> parseClaims(String jwtToken, Key signKey) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(signKey).build().parseClaimsJws(jwtToken).getBody();
            return Optional.of(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean validateWithoutExpiration(String jwtToken) {
        try {
            Jwts.parserBuilder().setSigningKey(JwtUtil.key).build().parseClaimsJws(jwtToken);
            return true;
        } catch (ExpiredJwtException | SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            if (e instanceof ExpiredJwtException) {
                return true;
            }
        }
        return false;
    }
}
