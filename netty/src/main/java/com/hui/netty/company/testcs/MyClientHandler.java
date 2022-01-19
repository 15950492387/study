package com.hui.netty.company.testcs;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Classname MyClientHandler
 * @Description TODO
 * @Date 2022/1/18 16:51
 * @Created by HUI
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        ctx.channel().writeAndFlush("6666");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("激活客户端");
        ctx.channel().writeAndFlush("6666");
    }

}
