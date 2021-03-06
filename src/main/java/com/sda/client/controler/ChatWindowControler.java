package com.sda.client.controler;

import com.sda.client.ClientSingleton;
import com.sda.client.ClientConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatWindowControler implements Initializable {
    private final ClientConnect client = ClientSingleton.getInstance();

    @FXML
    private Button loginButton, disconnectButton;

    @FXML
    private TextField chatMessageField, chatUsersField, chatAddMessageField;

    public void handleDisconnectButtonAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;

        if(actionEvent.getSource() == disconnectButton) {
            stage = (Stage) disconnectButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/clientfxml/LoginWindow.fxml"));
        } else {
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/clientfxml/ChatWindow.fxml"));
        }

        Scene scene = new Scene(root, 400, 100);
        stage.setScene(scene);
        stage.show();
    }

    public void handleAddMessageAction(ActionEvent actionEvent) throws IOException {
        String newMessage = chatAddMessageField.getText();
        if(newMessage.isEmpty() == false) {
            client.sendMessage(newMessage);
            chatAddMessageField.clear();

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
