package com.sda.client;

public class ClientSingleton {
    private static ClientConnect clientConnect = null;

    public static ClientConnect getInstance() {
        if (clientConnect == null) {
            clientConnect = new ClientConnect();
        }
        return clientConnect;
    }
}
