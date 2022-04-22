package com.mao.netty.rpc.server.service;

import java.util.List;

public interface TestService {
    List<String> listAll();

    String listByid(Integer id);
}
