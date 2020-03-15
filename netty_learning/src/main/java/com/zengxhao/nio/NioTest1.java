package com.zengxhao.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

public class NioTest1 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        SocketAddress socketAddress = new InetSocketAddress("localhost",8899);
        serverSocketChannel.bind(socketAddress);
    }
}
