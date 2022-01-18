package com.hui.netty.company.testcs;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Classname MyServer
 * @Description TODO
 * @Date 2022/1/18 16:26
 * @Created by HUI
 */
public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ChannelFuture sync = serverBootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new MyServerInitializer()).bind(8888).sync();
        sync.channel().closeFuture().sync();
    }

}
