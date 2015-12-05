package necat.share;

public interface NxChannel {

    public void read();

    public void write(Object msg);

    public void close();

}
