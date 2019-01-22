package com.mao.maoyan.getaway.modular.example;

import com.mao.maoyan.getaway.common.CurrentUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

    @GetMapping("")
    public ResponseEntity hello() {
        System.out.println(CurrentUser.getCurrentUser());

        return ResponseEntity.ok("请求成功!");
    }
}
