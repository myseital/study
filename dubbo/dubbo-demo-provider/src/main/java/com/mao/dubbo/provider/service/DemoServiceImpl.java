package com.mao.dubbo.provider.service;

import com.mao.dubbo.demo.DemoService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author myseital
 * @date 2022/4/12 19:51
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("执行了");
        URL url = RpcContext.getContext().getUrl();
        return String.format("%s: %s, Hello, %s", url.getProtocol(), url.getPort(), name);
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return DemoService.super.sayHelloAsync(name);
    }
}
