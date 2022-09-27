package com.mao.uaa.security.auth.ldap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.ldap.DataLdapTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author myseital
 * @date 2022/9/27
 */
@ActiveProfiles("dev")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@DataLdapTest
public class LDAPUserRepoIntTests {

    @Autowired
    private LDAPUserRepo ldapUserRepo;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void givenUsername_ThenFindUserSuccess() {
        Optional<LDAPUser> user = ldapUserRepo.findByUsername("zhaoliu");
        assertTrue(user.isPresent());
    }

    @Test
    public void givenUsernameAndPassword_ThenFindUserSuccess() {
        Optional<LDAPUser> user = ldapUserRepo.findByUsernameAndPassword("zhaoliu", "123");
        assertTrue(user.isPresent());
    }

    @Test
    public void givenUsernameAndWrongPassword_ThenFindUserFail() {
        Optional<LDAPUser> user = ldapUserRepo.findByUsernameAndPassword("zhaoliu", "bad_password");
        assertFalse(user.isPresent());
    }
}
