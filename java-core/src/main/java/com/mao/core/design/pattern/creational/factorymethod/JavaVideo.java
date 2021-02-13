package com.mao.core.design.pattern.creational.factorymethod;

/**
 * @author maojiawei
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
