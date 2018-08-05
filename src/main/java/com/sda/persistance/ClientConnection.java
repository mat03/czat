package com.sda.persistance;

import com.sda.client.Client;
import com.sda.message.Message;

public class ClientConnection {


    public ClientConnection() {
    }

    public void addNewUser(String userName) {
        Client.write(Message.NEW_USER + userName);
    }

    public void sendMessage(String message) {
        Client.write(Message.MESSAGE + message);
    }
}
