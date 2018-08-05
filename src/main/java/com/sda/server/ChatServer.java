package com.sda.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final Integer PORT = 8434;

    static List<Socket> sockets = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            boolean running = true;

            while (running) {
                Socket clientSocket = serverSocket.accept();
                sockets.add(clientSocket);
                ServerThreadService threadService = new ServerThreadService(clientSocket);

                Thread thread = new Thread(threadService);
                thread.start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
