package com.sda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadService implements Runnable{
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ServerThreadService(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            boolean running = true;

            while (running) {
                String message;
                if((message = reader.readLine()) != null) {
                    System.out.println("S:" + message);
                    for (Socket s: ChatServer.sockets) {
                        PrintWriter clientWrite = new PrintWriter(s.getOutputStream());
                        clientWrite.println(message);
                        clientWrite.flush();

                    }
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
