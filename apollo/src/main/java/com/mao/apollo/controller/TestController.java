package com.mao.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author myseital
 * @date 2021/5/26 16:51
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/apollo")
    public String apollo() {
        Config config = ConfigService.getAppConfig();
        String someKey = "task.retry.max.num";
        String value = config.getProperty(someKey, null);
        System.out.println("task.retry.max.num}: " + value);
        // -Dapp.id=joyingbox-erp-edi -Denv=DEV -Ddev_meta=http://dev-apollo.joyingbox.com/
        return value;
    }
}
