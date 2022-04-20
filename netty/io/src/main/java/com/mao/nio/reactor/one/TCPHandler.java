package com.mao.nio.reactor.one;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Handler線程
 */
public class TCPHandler implements Runnable {

    private final SelectionKey sk;
    private final SocketChannel sc;
    int state;

    public TCPHandler(SelectionKey sk, SocketChannel sc) {
        this.sk = sk;
        this.sc = sc;
        // 初始狀態設定為READING
        state = 0;
    }

    @Override
    public void run() {
        try {
            if (state == 0) {
                // 讀取網絡數據
                read();
            } else {
                // 發送網絡數據
                send();
            }
        } catch (IOException e) {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
        }
    }

    private void closeChannel() {
        try {
            sk.cancel();
            sc.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private synchronized void read() throws IOException {
        // non-blocking下不可用Readers，因為Readers不支援non-blocking
        byte[] arr = new byte[1024];
        ByteBuffer buf = ByteBuffer.wrap(arr);
        // 讀取字符串
        int numBytes = sc.read(buf);
        if (numBytes == -1) {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
            return;
        }
        // 將讀取到的byte內容轉為字符串型態
        String str = new String(arr);
        if ((str != null) && !str.equals(" ")) {
            // 邏輯處理
            process(str);
            System.out.println(sc.socket().getRemoteSocketAddress().toString() + " > " + str);
            // 改變狀態
            state = 1;
            // 通過key改變通道註冊的事件
            sk.interestOps(SelectionKey.OP_WRITE);
            // 使一個阻塞住的selector操作立即返回
            sk.selector().wakeup();
        }
    }

    private void send() throws IOException {
        // get message from message queue
        String str = "Your message has sent to " + sc.socket().getLocalSocketAddress().toString() + "\r\n";
        // wrap自動把buf的position設為0，所以不需要再flip()
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        while (buf.hasRemaining()) {
            // 回傳給client回應字符串，發送buf的position位置 到limit位置為止之間的內容
            sc.write(buf);
        }
        // 改變狀態
        state = 0;
        // 通過key改變通道註冊的事件
        sk.interestOps(SelectionKey.OP_READ);
        // 使一個阻塞住的selector操作立即返回
        sk.selector().wakeup();
    }

    void process(String str) {
        // do process(decode, logically process, encode)..
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}