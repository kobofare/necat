package necat.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;

public class NxBootstrapImpl implements NxBootstrap{
    private final AbstractBootstrap<?, ?> bootstrap;
   
    public NxBootstrapImpl(AbstractBootstrap<?, ?> bootstrap) {
        this.bootstrap = bootstrap;
    }
}
