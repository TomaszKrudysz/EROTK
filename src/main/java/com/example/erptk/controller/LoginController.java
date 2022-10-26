package com.example.erptk.controller;

import com.example.erptk.dto.UserCredentialsDto;
import com.example.erptk.factory.PopupFactory;
import com.example.erptk.rest.Authentication;
import com.example.erptk.rest.AuthenticationImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private PopupFactory popupFactory;
    private Authentication authentication;

    @FXML
    private Button exitButton;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    public LoginController(){
        popupFactory = new PopupFactory();
        authentication = new AuthenticationImpl();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeExitButton();
        initializeLoginButton();


    }

    private void initializeLoginButton() {
        loginButton.setOnAction((x)->{
            performAuthentication();
        });
    }

    private void performAuthentication() {
        Stage waitingPopup = popupFactory.createWaitingPopup("Connecting to the server");
        waitingPopup.show();
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
        authentication.authenticate(dto, (authenticationResult) ->{
            Platform.runLater(()->{
                waitingPopup.close();
                System.out.println("authenticationResult:  " + authenticationResult);

            });
        });

    }


    private void initializeExitButton() {
        exitButton.setOnAction((x)->{
            getStage().close();
        });
    }


    private Stage getStage(){
        return (Stage) loginAnchorPane.getScene().getWindow();
    }
}