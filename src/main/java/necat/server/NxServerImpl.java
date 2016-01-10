package necat.server;

import necat.channel.NxChannel;

public class NxServerImpl implements NxServer {
    private final NxChannel nxChannel;

    public NxServerImpl(NxChannel nxChannel) {
        this.nxChannel = nxChannel;
    }

    @Override
    public void close() {
        nxChannel.close();
    }
}
