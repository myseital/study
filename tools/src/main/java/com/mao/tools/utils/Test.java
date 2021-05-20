package com.mao.tools.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author myseital
 * @date 2021/5/7 20:28
 */
public class Test {
    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    lock.lock();
                    try {
                        while (count % 3 == 0) {
                            System.out.println(i + "a");
                            count++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    lock.lock();
                    try {
                        while (count % 3 == 1) {
                            System.out.println(i + "b");
                            count++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    lock.lock();
                    try {
                        while (count % 3 == 2) {
                            System.out.println(i + "c");
                            count++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
