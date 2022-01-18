package com.hui.netty.company.testcs;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Classname MyServerHandle
 * @Description TODO
 * @Date 2022/1/18 16:36
 * @Created by HUI
 */
public class MyServerHandle extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        ctx.channel().writeAndFlush("from server: " + msg);
    }
}
