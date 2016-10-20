package io.github.wspring;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by wangchun on 2016/10/11.
 */
public class ByteBufferOutputStream extends ByteArrayOutputStream {
    protected ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);

    public ByteBufferOutputStream() {
    }

    public ByteBufferOutputStream(ByteOrder order) {
        super();
        buffer.order(order);
    }

    public ByteBufferOutputStream(int size) {
        super(size);
    }

    public void order(ByteOrder order) {
        buffer.order(order);
    }

    public ByteOrder order() {
        return buffer.order();
    }

    public void writeShort(Short value) {
        buffer.clear();
        write(buffer.putShort(value).array(), 0, Short.BYTES);
    }

    public void writeInteger(Integer value) {
        buffer.clear();
        write(buffer.putInt(value).array(), 0, Integer.BYTES);
    }

    public Long writeLong(Long value) {
        buffer.clear();
        write(buffer.putLong(value).array(), 0, Long.BYTES);
    }
}
