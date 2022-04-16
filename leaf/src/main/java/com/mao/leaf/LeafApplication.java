package com.mao.leaf;

import com.mao.leaf.common.enums.Id4BizTagEnum;
import com.mao.leaf.service.IdService;
import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableLeafServer
@SpringBootApplication
public class LeafApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LeafApplication.class, args);
//        IdService bean = run.getBean(IdService.class);
//        Long orderDistributedId = bean.getOrderDistributedId(Id4BizTagEnum.B2C_ORDER);
//        System.out.println(orderDistributedId);
    }

}
