package com.mao.netty.rpc.client.netty;

import com.mao.netty.rpc.server.service.TestService;

public class ClientSocketNetty {
    public static void main(String[] args) throws InterruptedException {
//        while (true){
//            long start = System.currentTimeMillis();
//            TestService o = (TestService) ClientRpcProxy.create(TestService.class);
//            System.out.println(o.listAll());
//            long end = System.currentTimeMillis();
//            System.out.println(end-start);
//            Thread.sleep(1000);
//        }
        TestService o2 = (TestService) ClientRpcProxy.create(TestService.class);
        System.out.println(o2.listByid(0));
    }
}
