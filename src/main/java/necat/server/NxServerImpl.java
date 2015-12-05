package necat.server;

import necat.share.NxChannel;

public class NxServerImpl implements NxServer {
    private final NxChannel nxChannel;

    public NxServerImpl(NxChannel nxChannel) {
        this.nxChannel = nxChannel;
    }
}
