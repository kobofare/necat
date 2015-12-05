package necat.base.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import necat.client.NxClient;
import necat.client.NxClientFactory;
import necat.server.NxServer;
import necat.server.NxServerBuilder;
import necat.share.BaseTest;

public class ClientServerTest extends BaseTest {
    private String address = "localhost";
    private int port = 1314;

    public ClientServerTest() {

    }

    @Test
    public void testBase() throws Exception {
        NxServerBuilder builder = new NxServerBuilder(null, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast("ServerHandler", new EchoServerHandler());
            }
        });

        NxServer server = builder.build(address, port);
        final CountDownLatch latch = new CountDownLatch(1);
        NxClientFactory clientFactory = new NxClientFactory(null, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                logger.info("client address: {}, remote address: {}", ch.localAddress(), ch.remoteAddress());
                ChannelPipeline p = ch.pipeline();
                p.addLast(new EchoClientHandler());
                latch.countDown();
            }

        });
        NxClient client = clientFactory.generate(address, port);
        latch.await();

        Thread.sleep(10000);
    }
}
