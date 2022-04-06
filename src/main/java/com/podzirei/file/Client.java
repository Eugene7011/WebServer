package com.podzirei.file;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

    try (Socket clientSocket = new Socket("localhost", 3000);
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         OutputStream outputStream = clientSocket.getOutputStream();
         InputStream inputStream = clientSocket.getInputStream()) {

            String message = readClientInput(reader);

            outputStream.write(message.getBytes());
            System.out.println("Sending to server message: " + message);
            System.out.println();

            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);

            System.out.print("Reply from server: " + new String(buffer, 0, count));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static String readClientInput (BufferedReader reader) throws IOException {
        System.out.print("Please enter your message to Server: ");
        String message = reader.readLine();
        if (message.isEmpty()) {
            System.out.println("ERROR! You entered nothing!");
        }
        return message;
    }
}
