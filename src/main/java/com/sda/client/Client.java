package com.sda.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Application {
    // host serwera
    private static final String HOSTNAME = "localhost";
    //    port serwera
    private static final Integer PORT = 8400;

    Button button;

    public static void main(String[] args) throws IOException {

        launch(args);
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Czat");

        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
