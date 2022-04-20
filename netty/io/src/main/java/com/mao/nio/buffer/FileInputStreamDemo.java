package com.mao.nio.buffer;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("netty\\io\\src\\main\\resources\\fileInputStreamDemo.txt");
        FileChannel channel = fileInputStream.getChannel();
        // 堆内
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            System.out.println((char) byteBuffer.get());
        }
//        while (true) {
//            int read = channel.read(byteBuffer);
//            if (read < 0) {
//                break;
//            }
//            System.out.println(read);
//            byteBuffer.flip();
//            String string = new String(byteBuffer.array());
//            System.out.println(string);
//        }
        fileInputStream.close();
    }
}
