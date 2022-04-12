package com.mao.rocketmq.project.order.web;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mao.rocketmq.project.store.api.HelloServiceApi;

@RestController
public class HelloController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            interfaceName = "com.mao.rocketmq.project.store.service.HelloServiceApi",
            check = false,
            timeout = 1000,
            retries = 0
    )
	private HelloServiceApi helloService;
    
    @RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return helloService.sayHello(name);
	}
}
