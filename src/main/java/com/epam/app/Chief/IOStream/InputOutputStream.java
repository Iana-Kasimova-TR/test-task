package com.epam.app.Chief.IOStream;

import java.io.*;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class InputOutputStream {

    private InputStream inputstream;

    private OutputStream outputStream;

    private String path;

    public InputOutputStream(String path) {
        this.path = path;
    }

    public void read() throws IOException {
        inputstream = new FileInputStream(path);
        int data = inputstream.read();
        char content;
        while(data != -1) {
            content = (char) data;
            System.out.print(content);
            data = inputstream.read();
        }
        inputstream.close();
    }

    public void write(String st) throws IOException {
        outputStream = new FileOutputStream(path);
        outputStream.write(st.getBytes());
        outputStream.close();
    }
}
