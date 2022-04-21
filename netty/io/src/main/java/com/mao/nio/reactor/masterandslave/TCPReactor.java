package com.mao.nio.reactor.masterandslave;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor線程
 */
public class TCPReactor implements Runnable {

    private final ServerSocketChannel ssc;
    /**
     * mainReactor用的selector
     */
    private final Selector selector;

    public TCPReactor(int port) throws IOException {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        // 設置ServerSocketChannel為非阻塞
        ssc.configureBlocking(false);
        Acceptor acceptor = new Acceptor(ssc);
        // ServerSocketChannel向selector註冊一個OP_ACCEPT事件，然後返回該通道的key
        SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 給定key一個附加的Acceptor對象
        sk.attach(acceptor);
        InetSocketAddress addr = new InetSocketAddress(port);
        // 在ServerSocketChannel綁定監聽端口
        ssc.socket().bind(addr);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            // 在線程被中斷前持續運行
            System.out.println("mainReactor waiting for new event on port: " + ssc.socket().getLocalPort() + "...");
            try {
                if (selector.select() == 0) {
                    // 若沒有事件就緒則不往下執行
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 取得所有已就緒事件的key集合
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectedKeys.iterator();
            while (it.hasNext()) {
                // 根據事件的key進行調度
                dispatch((it.next()));
                it.remove();
            }
        }
    }

    /**
     * 調度方法，根據事件綁定的對象開新線程
     */
    private void dispatch(SelectionKey key) {
        // 根據事件之key綁定的對象開新線程
        Runnable r = (Runnable) (key.attachment());
        if (r != null) {
            r.run();
        }
    }
}