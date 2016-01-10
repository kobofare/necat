package necat.configuration;

import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;

import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannelConfig;

public abstract class NxChannelConfiguration implements SocketChannelConfig {

    @Override
    public Map<ChannelOption<?>, Object> getOptions() {
        throw new NotImplementedException("not supported");
    }

    @Override
    public boolean setOptions(Map<ChannelOption<?>, ?> options) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public <T> T getOption(ChannelOption<T> option) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public int getTrafficClass() {
        throw new NotImplementedException("not supported");
    }

    @Override
    public SocketChannelConfig setTrafficClass(int trafficClass) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public SocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public boolean isAllowHalfClosure() {
        throw new NotImplementedException("not supported");
    }

    @Override
    public SocketChannelConfig setAllowHalfClosure(boolean allowHalfClosure) {
        throw new NotImplementedException("not supported");
    }

    @Override
    public int getMaxMessagesPerRead() {
        throw new NotImplementedException("not supported");
    }

    @Override
    public SocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        throw new NotImplementedException("not supported");
    }
}
