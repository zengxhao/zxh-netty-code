package com.zengxhao.netty.thirdexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferExample {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        buffer.limit(1).position(20);
            //buffer.clear();
            int read = inputStreamChannel.read(buffer);
        System.out.println(read);
            buffer.flip();
            outputStreamChannel.write(buffer);


}
}
