package com.mao.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/6/23 13:06
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }


    @GetMapping("/public")
    public String testPublic() {
        return "public";
    }
}
