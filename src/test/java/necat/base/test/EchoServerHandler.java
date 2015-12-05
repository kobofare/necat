package necat.base.test;

import necat.utils.BufferUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private final static Logger logger = LoggerFactory.getLogger(EchoServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        logger.info("size: {}, long: {}", msg.readableBytes(), BufferUtils.byteBufToString(msg));
        ByteBuf echo = Unpooled.wrappedBuffer(new byte[msg.readableBytes()]);
        msg.readBytes(echo);
        ctx.writeAndFlush(echo);
    }

}
