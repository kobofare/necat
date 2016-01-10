package necat.bootstrap;

import io.netty.bootstrap.ChannelFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ServerChannel;

public class ServerNioBootstrapFactory extends AbstractNioBootstrapFactory {

    public ServerNioBootstrapFactory() {

    }

    @Override
    public NxBootstrap build() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        
        return new NxBootstrapImpl(bootstrap);
    }
}
