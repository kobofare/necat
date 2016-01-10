package necat.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import necat.configuration.NxConfiguration;

public class ClientNioBootstrapFactory extends AbstractNioBootstrapFactory {

    public NxBootstrap build() {
        NxConfiguration nxConfiguration = getNxConfiguration();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup(nxConfiguration.getWorkerGroupCount()));
        bootstrap.channel(NioSocketChannel.class);

        return new NxBootstrapImpl(bootstrap);
    }

    public class NxChannelInitializer<A extends SocketChannel> extends ChannelInitializer<A> {

        @Override
        protected void initChannel(A ch) throws Exception {
            // TODO Auto-generated method stub

        }

    }

}
