package com.podzirei.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[100];

        int count = inputStream.read(buffer);

        String received = new String(buffer, 0, count);

        String echoMessage = "Echo: " + received;

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(echoMessage.getBytes());

    }

}
