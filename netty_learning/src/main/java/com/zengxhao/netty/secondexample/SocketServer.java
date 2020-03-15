package com.zengxhao.netty.secondexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup bossEvent = new NioEventLoopGroup();
        EventLoopGroup workerEvent = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossEvent,workerEvent).channel(NioServerSocketChannel.class).childHandler(new SocketInitializer());
            ChannelFuture channelFuture = bootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossEvent.shutdownGracefully();
            workerEvent.shutdownGracefully();
        }
    }
}
