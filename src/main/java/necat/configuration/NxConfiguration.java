package necat.configuration;

public abstract class NxConfiguration extends NxChannelConfiguration {

    public abstract int getWorkerGroupCount();

    public abstract NxConfiguration setWorkerGroupCount(int workerGroupCount);

}
