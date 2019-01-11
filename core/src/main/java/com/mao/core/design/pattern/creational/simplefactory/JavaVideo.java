package com.mao.core.design.pattern.creational.simplefactory;

/**
 * @author maojiawei
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
