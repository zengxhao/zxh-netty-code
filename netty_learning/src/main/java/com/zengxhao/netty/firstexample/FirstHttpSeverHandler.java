package com.zengxhao.netty.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class FirstHttpSeverHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest) {
            ByteBuf buf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
            HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/xml");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}
