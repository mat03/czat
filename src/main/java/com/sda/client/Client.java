package com.sda.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
    // host serwera
    private static final String HOSTNAME = "localhost";
    //    port serwera
    private static final Integer PORT = 8400;

    private static BufferedReader reader;
    private static PrintWriter printWriter;

    public static String read() throws IOException {
        return reader.readLine() ;
    }

    public static void write(String message) {
        printWriter.println(message);
        printWriter.flush();
    }

    private void clientStart() throws IOException {


        //Wysyłanie wiadomości do serwera
        printWriter.println("Hello from client!");
        //Wypchanie z bufora
        printWriter.flush();

        //Odczyt z serwera
        String response = reader.readLine();
        System.out.println("Response: " + response);
        //Zamknięcie strumienii
        //printWriter.close();
        //reader.close();
        //socket.close();
    }

    public Client() throws IOException {
        //Tworzymy gniazdo do polaczenia z serwerem
        Socket socket = new Socket(HOSTNAME, PORT);
        //BufferedReader - obiekt do odczytu danych z serwera
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //PrintWriter - obiekt do wysyłania danych do serwera
        printWriter = new PrintWriter(socket.getOutputStream());
    }



    @Override
    public void run() {

    }
}
