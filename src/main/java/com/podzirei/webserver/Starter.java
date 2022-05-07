package com.podzirei.webserver;

import com.podzirei.webserver.server.Server;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
        Server server = new Server();
        server.setPort(3000);

         try {
            server.start();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
