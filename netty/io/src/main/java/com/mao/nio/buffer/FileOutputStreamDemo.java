package com.mao.nio.buffer;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("netty\\io\\src\\main\\resources\\fileOutputStreamDemo.txt");
        FileChannel channel = fileOutputStream.getChannel();
        byte[] bytes = "FileOutputStreamDemo2".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
