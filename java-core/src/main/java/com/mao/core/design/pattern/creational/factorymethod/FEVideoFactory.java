package com.mao.core.design.pattern.creational.factorymethod;

/**
 * @author maojiawei
 */
public class FEVideoFactory extends VideoFactory{
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
