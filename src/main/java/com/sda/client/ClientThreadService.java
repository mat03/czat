package com.sda.client;

import javafx.event.Event;
import javafx.event.EventType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThreadService implements Runnable {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private ArrayList<String> readFromServer;
    private EventType<ClientEvent> options;

    public ClientThreadService(Socket socket) throws IOException {
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        readFromServer = new ArrayList();
        options = new EventType<>("options");
    }

    public boolean isReadArrayEmpty() {
        return readFromServer.isEmpty();
    }

    void readFromServer() {

    }

    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }
    public void run() {
        boolean running = true;
        try {
            String message;
            while (running) {
                if ((message = reader.readLine()) != null) {
                    readFromServer.add(message);
                    System.out.println("R: "+ message);
                   Event event = new ClientEvent(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
