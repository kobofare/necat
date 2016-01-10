package necat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import necat.channel.NxChannel;
import necat.channel.NxChannelImpl;
import necat.configuration.NxChannelConfiguration;
import necat.exception.NxIOException;

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

    private final NxChannelConfiguration configuration;
    private final ChannelInitializer<SocketChannel> initializer;

    public NxClientFactory(NxChannelConfiguration configuration, ChannelInitializer<SocketChannel> initializer) {
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
    
    public class NxChannelInitializer<A extends SocketChannel> extends ChannelInitializer<A> {

        @Override
        protected void initChannel(A ch) throws Exception {
            // TODO Auto-generated method stub
            
        }
        
    }
}
