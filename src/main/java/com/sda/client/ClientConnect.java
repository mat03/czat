package com.sda.client;

import com.sda.client.thread.ClientThreadService;
import com.sda.message.Constant;

import java.io.IOException;
import java.net.Socket;

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

    public void addNewUser(String userName) {
        threadService.sendMessage(Constant.NEW_USER + userName);
    }

    public void sendMessage(String message) {
        threadService.sendMessage(Constant.MESSAGE + message);
    }
}
