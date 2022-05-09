package com.mao.concurrency.syn;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.GC;

/**
 * @author myseital
 * @date 2022/4/26 00:00
 */
public class HelloJOL {
    
    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
