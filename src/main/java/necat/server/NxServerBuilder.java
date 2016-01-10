package necat.server;

import necat.channel.NxChannelImpl;
import necat.configuration.NxChannelConfiguration;
import necat.exception.NxIOException;
import necat.share.NxChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NxServerBuilder {
    private final ChannelInitializer<SocketChannel> initializer;
    private final NxChannelConfiguration configuration;

    public NxServerBuilder(NxChannelConfiguration configuration, ChannelInitializer<SocketChannel> initializer) {
        this.configuration = configuration;
        this.initializer = initializer;
    }

    public NxServer build(String address, int port) throws NxIOException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.group(bossGroup, workerGroup);
        bootstrap.handler(new LoggingHandler(LogLevel.INFO));
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(initializer);
        Channel channel;
        try {
            channel = bootstrap.bind(address, port).sync().channel();
        } catch (InterruptedException e) {
            throw new NxIOException("can not bind to " + address + ":" + port);
        }

        return new NxServerImpl(new NxChannelImpl(channel));
    }
}
