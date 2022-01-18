package com.hui.netty.company.testcs;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Classname MyClient
 * @Description TODO
 * @Date 2022/1/18 16:44
 * @Created by HUI
 */
public class MyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new MyClierntInitializer())
                .connect("localhost", 8888).sync();
    }
}
