package necat.channel;

public interface NxChannel {

    public void read();

    public void write(Object msg);

    public void close();

}
