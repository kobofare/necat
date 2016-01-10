package necat.bootstrap;

import necat.configuration.NxConfiguration;
import necat.configuration.NxConfigurationImpl;

public abstract class AbstractNioBootstrapFactory implements BootstrapFactory {
    private NxConfiguration nxConfiguration = NxConfigurationImpl.DEFAULT;

    @Override
    public NxBootstrap build() {
        return null;
    }

    public NxConfiguration getNxConfiguration() {
        return nxConfiguration;
    }

    public void setNxConfiguration(NxConfiguration nxConfiguration) {
        this.nxConfiguration = nxConfiguration;
    }
}
