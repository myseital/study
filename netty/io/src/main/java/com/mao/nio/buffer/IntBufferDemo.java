package com.mao.nio.buffer;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class IntBufferDemo {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int nextInt = new SecureRandom().nextInt(20);
            buffer.put(nextInt);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
