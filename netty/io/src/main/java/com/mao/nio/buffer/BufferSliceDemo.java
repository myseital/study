package com.mao.nio.buffer;

import java.nio.ByteBuffer;

public class BufferSliceDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); ++i) {
            byteBuffer.put((byte) i);
        }
//        byteBuffer.mark();
        byteBuffer.position(2);
        byteBuffer.limit(8);
        // 创建新的字节缓冲区，其内容是此缓冲区position之后内容所共享的
        ByteBuffer resetBuffer = byteBuffer.slice();
        for (int i = 0; i < resetBuffer.capacity(); i++) {
            byte anInt = resetBuffer.get();
            resetBuffer.put(i, (byte) (anInt * 2));
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
//        byteBuffer.reset();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

    }
}
