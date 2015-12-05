package necat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import necat.exception.NxIOException;
import necat.share.NxChannel;
import necat.share.NxChannelImpl;
import necat.share.NxConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * If we want to communication with server, we just produce a new client. But you should prepare some thing for building
 * a client, such as configuration, pipeline handler and so on.
 * 
 * @author lx
 *
 */
public class NxClientFactory {
    private final static Logger logger = LoggerFactory.getLogger(NxClientFactory.class);

    private final NxConfiguration configuration;
    private final ChannelInitializer<SocketChannel> initializer;

    public NxClientFactory(NxConfiguration configuration, ChannelInitializer<SocketChannel> initializer) {
        this.configuration = configuration;
        this.initializer = initializer;
    }

    public NxClient generate(String address, int port) throws NxIOException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(initializer);

        logger.info("connect to server: {}:{}", address, port);
        ChannelFuture future;
        try {
            future = bootstrap.connect(address, port).sync();
        } catch (InterruptedException e) {
            throw new NxIOException("can not connect to " + address + ":" + port);
        }

        NxChannel nxChannel = new NxChannelImpl(future.channel());

        return new NxClientImpl(nxChannel);
    }
}
