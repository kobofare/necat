package necat.utils;

import io.netty.buffer.ByteBuf;

public class BufferUtils {

    public static String byteBufToString(ByteBuf byteBuf) {
        return byteBufToString(byteBuf, byteBuf.readableBytes());
    }

    public static String byteBufToString(ByteBuf byteBuf, int maxLength) {
        StringBuilder builder = new StringBuilder();
        for (int begin = byteBuf.readerIndex(); begin < byteBuf.writerIndex(); begin++) {
            builder.append(byteBuf.getByte(begin));
        }
        return builder.toString();
    }
}
