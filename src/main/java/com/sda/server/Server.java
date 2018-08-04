package com.sda.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //Port na którym startuje serwer
    private static final Integer PORT = 8400;
    // Czas uśpienia - 6 sek
    private static final Long SLEEP_TIME = 6000L;

    public static void main(String[] args) throws Exception {


//      Gniazdo serwera. Służy do przyjmowania klientów TCP
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Started server on port " + PORT);

        while (true) {
            System.out.println("Waiting for client...");
            //Czeka na klienta
            Socket clientSocket = serverSocket.accept();
            //BufferedReader odczytuje to co wysłał klient
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //PrintWriter służy do wysyłania wiadomości do klienta
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

            //Odczyt od klienta
            String line = reader.readLine();
            System.out.println("Received: " + line);
            //Uspij na 6 sek. Symulacja obliczeń
            Thread.sleep(SLEEP_TIME);
            //Odpowiedź do klienta
            printWriter.println("Response from server: " + line);
            //Wypchanie z bufora
            printWriter.flush();
            //Zamknięcie strumienii
            printWriter.close();
            reader.close();
        }
    }
}
