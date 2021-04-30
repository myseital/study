package com.mao.springboot.my.springboot.starter.service;

/**
 * @author myseital
 * @date 2021/4/30 17:26
 */
public class MyService {

    public String sayWhat;
    public String toWho;

    public MyService(String sayWhat, String toWho) {
        this.sayWhat = sayWhat;
        this.toWho = toWho;
    }

    public String say() {
        return this.sayWhat + "!  " + toWho;
    }
}
