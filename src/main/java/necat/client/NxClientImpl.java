package necat.client;

import necat.channel.NxChannel;

public class NxClientImpl implements NxClient {
    private final NxChannel nxChannel;

    public NxClientImpl(NxChannel nxChannel) {
        this.nxChannel = nxChannel;
    }

}
