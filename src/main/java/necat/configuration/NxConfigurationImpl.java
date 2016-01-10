package necat.configuration;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.DefaultMessageSizeEstimator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.SocketChannelConfig;

public class NxConfigurationImpl extends NxConfiguration {
    public static final NxConfiguration DEFAULT = new NxConfigurationImpl();

    /**
     * the parameters are for {@link ChannelConfig}
     */
    private int connectTimeoutMillis = 3000;
    private int writeSpinCount = 16;
    private boolean autoRead = true;
    private boolean autoClose = true;
    private int writeBufferHighWaterMark = 64 * 1024;
    private int writeBufferLowWaterMark = 32 * 1024;
    private MessageSizeEstimator messageSizeEstimator = DefaultMessageSizeEstimator.DEFAULT;
    private ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
    private RecvByteBufAllocator recvByteBufAllocator = AdaptiveRecvByteBufAllocator.DEFAULT;

    /**
     * this parameters are for {@link SocketChannelConfig}
     */
    private boolean tcpNoDelay = true;
    private int soLinger = 0;
    private int sendBufferSize = 64 * 1024;
    private int receiveBufferSize = 64 * 1024;
    private boolean keepAlive = false;
    private boolean reuseAddress = true;

    /**
     * this parameters are for {@link NxConfiguration}
     */
    private int workerGroupCount = Runtime.getRuntime().availableProcessors();

    @Override
    public int getConnectTimeoutMillis() {
        return connectTimeoutMillis;
    }

    @Override
    public SocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        this.connectTimeoutMillis = connectTimeoutMillis;
        return this;
    }

    @Override
    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    @Override
    public SocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        this.allocator = allocator;
        return this;
    }

    @Override
    public RecvByteBufAllocator getRecvByteBufAllocator() {
        return recvByteBufAllocator;
    }

    @Override
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        this.recvByteBufAllocator = allocator;
        return this;
    }

    @Override
    public boolean isAutoRead() {
        return this.autoRead;
    }

    @Override
    public SocketChannelConfig setAutoRead(boolean autoRead) {
        this.autoRead = autoRead;
        return this;
    }

    @Override
    public boolean isAutoClose() {
        return this.autoClose;
    }

    @Override
    public SocketChannelConfig setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        return this;
    }

    @Override
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferHighWaterMark;
    }

    @Override
    public SocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        this.writeBufferHighWaterMark = writeBufferHighWaterMark;
        return this;
    }

    @Override
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferLowWaterMark;
    }

    @Override
    public SocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        this.writeBufferLowWaterMark = writeBufferLowWaterMark;
        return this;
    }

    @Override
    public MessageSizeEstimator getMessageSizeEstimator() {
        return this.messageSizeEstimator;
    }

    @Override
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        this.messageSizeEstimator = estimator;
        return this;
    }

    @Override
    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    @Override
    public SocketChannelConfig setTcpNoDelay(boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
        return this;
    }

    @Override
    public int getSoLinger() {
        return this.soLinger;
    }

    @Override
    public SocketChannelConfig setSoLinger(int soLinger) {
        this.soLinger = soLinger;
        return this;
    }

    @Override
    public int getSendBufferSize() {
        return this.sendBufferSize;
    }

    @Override
    public SocketChannelConfig setSendBufferSize(int sendBufferSize) {
        this.sendBufferSize = sendBufferSize;
        return this;
    }

    @Override
    public int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    @Override
    public SocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        this.receiveBufferSize = receiveBufferSize;
        return this;
    }

    @Override
    public boolean isKeepAlive() {
        return this.keepAlive;
    }

    @Override
    public SocketChannelConfig setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
        return this;
    }

    @Override
    public boolean isReuseAddress() {
        return this.reuseAddress;
    }

    @Override
    public SocketChannelConfig setReuseAddress(boolean reuseAddress) {
        this.reuseAddress = reuseAddress;
        return this;
    }

    @Override
    public int getWorkerGroupCount() {
        return this.workerGroupCount;
    }

    @Override
    public NxConfiguration setWorkerGroupCount(int workerGroupCount) {
        this.workerGroupCount = workerGroupCount;
        return this;
    }

    @Override
    public SocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        this.writeSpinCount = writeSpinCount;
        return this;
    }

    @Override
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    @Override
    public String toString() {
        return "NxConfigurationImpl [connectTimeoutMillis=" + connectTimeoutMillis + ", writeSpinCount="
                + writeSpinCount + ", autoRead=" + autoRead + ", autoClose=" + autoClose + ", writeBufferHighWaterMark="
                + writeBufferHighWaterMark + ", writeBufferLowWaterMark=" + writeBufferLowWaterMark
                + ", messageSizeEstimator=" + messageSizeEstimator + ", allocator=" + allocator
                + ", recvByteBufAllocator=" + recvByteBufAllocator + ", tcpNoDelay=" + tcpNoDelay + ", soLinger="
                + soLinger + ", sendBufferSize=" + sendBufferSize + ", receiveBufferSize=" + receiveBufferSize
                + ", keepAlive=" + keepAlive + ", reuseAddress=" + reuseAddress + ", workerGroupCount="
                + workerGroupCount + "]";
    }

}
