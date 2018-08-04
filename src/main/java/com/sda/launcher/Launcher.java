package com.sda.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loggin = FXMLLoader.load(getClass().getResource("/fxml/ChatWindow.fxml"));
        primaryStage.setTitle("Anonymous");
        primaryStage.setScene(new Scene(loggin, 400, 1000));
        primaryStage.show();
    }
}
