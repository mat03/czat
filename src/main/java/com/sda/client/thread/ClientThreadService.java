package com.sda.client.thread;

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

    public ClientThreadService(Socket socket) throws IOException {
        this.socket = socket;
        writer = new PrintWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        readFromServer = new ArrayList();
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
