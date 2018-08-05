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

public class LoginWindowControler {
    private final ClientConnect client = Client.getInstance();

    @FXML
    private TextField loginNameField;

    @FXML
    private Button loginButton, disconnectButton;

    public void handleloginButtonAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;

        if(actionEvent.getSource() == loginButton) {
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/ChatWindow.fxml"));
        } else {
            stage = (Stage) disconnectButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/LoginWindow.fxml"));
        }

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        String loginName = loginNameField.getText();

        if(loginName.isEmpty() == false) {

            client.addNewUser(loginName);
        }


    }
}
