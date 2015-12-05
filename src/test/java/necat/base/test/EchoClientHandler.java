package necat.base.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(EchoClientHandler.class);

    public void channelActive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        logger.info("client address: {}, remote address: {}", channel.localAddress(), channel.remoteAddress());
        ByteBuf byteBuf = Unpooled.buffer(8);
        byteBuf.writeLong(131413141314l);
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("channel read");
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        logger.info("read complete");
        ctx.flush();
    }
}
