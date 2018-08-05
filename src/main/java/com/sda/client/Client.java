package com.sda.client;

public class Client {
    private static ClientConnect clientConnect = null;

    public static ClientConnect getInstance() {
        if (clientConnect == null) {
            clientConnect = new ClientConnect();
        }
        return clientConnect;
    }
}
