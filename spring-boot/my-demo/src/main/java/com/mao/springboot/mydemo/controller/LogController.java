package com.mao.springboot.mydemo.controller;

import com.mao.springboot.mydemo.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2022/8/30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @GetMapping("/test")
    public void test() {
        String name = "name";
        Long id = 1L;
        logService.testLog(id, name);
    }
}
