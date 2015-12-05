package necat.share;

import io.netty.channel.Channel;

public class NxChannelImpl implements NxChannel {
    private final Channel channel;

    public NxChannelImpl(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void read() {

    }

    @Override
    public void write(Object msg) {

    }

    @Override
    public void close() {
        channel.close();
    }
}
