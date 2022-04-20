package com.mao.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferAllocateDirectDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("netty\\io\\src\\main\\resources\\demo8write.txt");
        FileInputStream fileInputStream = new FileInputStream("netty\\io\\src\\main\\resources\\demo8read.txt");

        FileChannel channelRead = fileInputStream.getChannel();
        FileChannel channelWrite = fileOutputStream.getChannel();

        // 堆外
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        while (true) {
            byteBuffer.clear();
            int readNumber = channelRead.read(byteBuffer);
            System.out.println(readNumber);
            if (readNumber == -1) {
                break;
            }
            byteBuffer.flip();
            channelWrite.write(byteBuffer);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
