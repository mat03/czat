package com.sda.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnect {
    private static final Integer PORT = 8434;
    private static final String HOSTNAME = "localhost";

    private Socket clientSocket;
    private ClientThreadService threadService;

    public ClientConnect() {
        try {
            clientSocket = new Socket(HOSTNAME, PORT);
            threadService = new ClientThreadService(clientSocket);

            Thread thread = new Thread(threadService);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        threadService.sendMessage(message);
    }
}
