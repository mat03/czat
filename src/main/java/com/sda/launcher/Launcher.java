package com.sda.launcher;

import com.sda.client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(new Client());
        thread.start();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loggin = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        primaryStage.setTitle("Anonymous");
        primaryStage.setScene(new Scene(loggin, 400, 100));
        primaryStage.show();
    }
}
