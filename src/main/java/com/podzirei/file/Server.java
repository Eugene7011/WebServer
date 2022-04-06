package com.podzirei.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            Socket socket = serverSocket.accept();
            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {

                byte[] buffer = new byte[100];
                int count = inputStream.read(buffer);

                String received = new String(buffer, 0, count);
                System.out.println("Message from client: " + received);
                System.out.println("Adding prefix ...");

                String echoMessage = "Echo: " + received;
                outputStream.write(echoMessage.getBytes());
                System.out.println("This message was sent to client " + echoMessage);
            }
        }
    }

}
