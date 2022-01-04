package com.podzirei.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSecond {
    public static void main(String[] args) throws IOException {

        System.out.println("Please enter your message to Server");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        if(message.equals("")){
            System.out.println("ERROR! You entered nothing!");
        }

        Socket socket = new Socket("localhost", 3000);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());

        System.out.println();

        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[100];

        int count = inputStream.read(buffer);

        System.out.println(new String(buffer, 0, count));
    }
}
