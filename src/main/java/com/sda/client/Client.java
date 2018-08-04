package com.sda.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    // host serwera
    private static final String HOSTNAME = "localhost";
    //    port serwera
    private static final Integer PORT = 8400;

    public static void main(String[] args) throws IOException {

        //Tworzymy gniazdo do polaczenia z serwerem
        Socket socket = new Socket(HOSTNAME, PORT);
        //BufferedReader - obiekt do odczytu danych z serwera
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //PrintWriter - obiekt do wysyłania danych do serwera
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        //Wysyłanie wiadomości do serwera
        printWriter.println("Hello from client!");
        //Wypchanie z bufora
        printWriter.flush();

        //Odczyt z serwera
        String response = reader.readLine();
        System.out.println("Response: " + response);
        //Zamknięcie strumienii
        printWriter.close();
        reader.close();
        socket.close();


    }
}
