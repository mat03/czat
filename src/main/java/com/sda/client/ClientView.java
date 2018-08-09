package com.sda.client;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientView extends Application{

    public static void main(String[] args) {
        launch(args);
        ClientConnect client = ClientSingleton.getInstance();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loggin = FXMLLoader.load(getClass().getResource("/clientfxml/LoginWindow.fxml"));
        primaryStage.setTitle("Anonymous");
        primaryStage.setScene(new Scene(loggin, 400, 100));
        primaryStage.show();
    }
}
