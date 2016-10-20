package io.github.wspring;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Created by wangchun on 2016/10/11.
 */
public class ByteBufferInputStream extends ByteArrayInputStream {

    protected ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES).order(ByteOrder.nativeOrder());

    public ByteBufferInputStream(byte[] buf) {
        super(buf);
    }

    public ByteBufferInputStream(ByteBuffer buf) {
        super(Arrays.copyOf(buf.array(), buf.remaining()), buf.position(), buf.remaining());
        buffer.order(buf.order());
    }

    public void order(ByteOrder order) {
        buffer.order(order);
    }

    public ByteOrder order() {
        return buffer.order();
    }

    public Short readShort() throws IOException {
        buffer.clear();
        if (read(buffer.array(), 0, Short.BYTES) == -1) {
            throw new EOFException();
        }
        return buffer.getShort();
    }

    public Integer readInteger() throws IOException {
        buffer.clear();
        if (read(buffer.array(), 0, Integer.BYTES) == -1) {
            throw new EOFException();
        }
        return buffer.getInt();
    }

    public Long readLong() throws IOException {
        buffer.clear();
        if (read(buffer.array(), 0, Long.BYTES) == -1) {
            throw new EOFException();
        }
        return buffer.getLong();
    }
}
