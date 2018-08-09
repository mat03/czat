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

public class LoginWindowControler implements Initializable {
    private final ClientConnect client = ClientSingleton.getInstance();

    @FXML
    private TextField loginNameField;

    @FXML
    private Button loginButton, disconnectButton;

    public void handleloginButtonAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        String userName = loginNameField.getText();

        if(userName.isEmpty() == false) {

            client.addNewUser(userName);
        }

        if(actionEvent.getSource() == loginButton) {
            stage = (Stage) loginButton.getScene().getWindow();
            stage.setTitle(userName);
            root = FXMLLoader.load(getClass().getResource("/clientfxml/ChatWindow.fxml"));
        } else {
            stage = (Stage) disconnectButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/clientfxml/LoginWindow.fxml"));
        }

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
