package com.mao.nio.buffer;

import java.nio.ByteBuffer;

public class BufferAsReadOnlyBufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer byteBufferR = byteBuffer.asReadOnlyBuffer();
        System.out.println(byteBuffer.getClass());
        System.out.println(byteBufferR.getClass());
        System.out.println(byteBufferR.position());
        byteBufferR.flip();
        System.out.println(byteBufferR.position());
        for (int i = 0; i < byteBufferR.capacity(); i++) {
            System.out.println(byteBufferR.get());
        }
        System.out.println(byteBuffer.position());
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            System.out.println(byteBuffer.get());
        }

        // throws ReadOnlyBufferException
        byteBufferR.put((byte) 11);
    }
}
