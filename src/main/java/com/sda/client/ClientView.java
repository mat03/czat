package com.sda.client;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class ClientView extends Application{
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Integer PORT = 8434;
    private static final String HOSTNAME = "localhost";


    public static void main(String[] args) {
        launch(args);
        ClientConnect client = Client.getInstance();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loggin = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        primaryStage.setTitle("Anonymous");
        primaryStage.setScene(new Scene(loggin, 400, 100));
        primaryStage.show();
    }
}
