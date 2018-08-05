package com.sda.controler;

import com.sda.client.Client;
import com.sda.client.ClientConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatWindowControler {
    private final ClientConnect client = Client.getInstance();

    @FXML
    private Button loginButton, disconnectButton;

    @FXML
    private TextField chatMessageField, chatUsersField, chatAddMessageField;

    public void handleDisconnectButtonAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;

        if(actionEvent.getSource() == disconnectButton) {
            stage = (Stage) disconnectButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        } else {
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/ChatWindow.fxml"));
        }

        Scene scene = new Scene(root, 400, 100);
        stage.setScene(scene);
        stage.show();
    }

    public void handleAddMessageAction(ActionEvent actionEvent) {

    }
}
