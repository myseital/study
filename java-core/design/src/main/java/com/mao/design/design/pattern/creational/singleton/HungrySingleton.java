package com.mao.design.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author maojiawei
 */
public class HungrySingleton implements Serializable, Cloneable {

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
