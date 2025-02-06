package com.example.laba4_lera.Controllers;



import com.example.laba4_lera.Models.User;
import com.example.laba4_lera.Services.UsersService;
import com.example.laba4_lera.Exception.UsersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {
    @FXML
    private Button welcome;
    @FXML
    private Button registration;
    @FXML
    private TextField login = new TextField();
    @FXML
    private PasswordField password = new PasswordField();
    @FXML
    private Label MessageLabel;
    public static User user = null;

    @FXML
    void initialize() {
        welcome.setOnAction(actionEvent -> {
            try {
                if (!password.getText().isEmpty() && !login.getText().isEmpty()) {
                    if (UsersService.checkUsers(password.getText().trim(), login.getText().trim())) {
                        user = UsersService.getUser(password.getText().trim(), login.getText().trim());
                        openMenu();
                    } else throw new UsersException();


                }

            } catch (UsersException e) {
                MessageLabel.setText("Неправильный пароль или логин!");
                login.setStyle("-fx-border-color: red");
                password.setStyle("-fx-border-color: red");
            }

        });

        registration.setOnAction(this::openRegistration);
    }


    @FXML
    void openMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/laba4_lera/menu.fxml"));
            Parent scene = fxmlLoader.load();
            Stage stage = (Stage)(welcome.getScene().getWindow());
            stage.setScene(new Scene(scene));
            stage.setTitle("Menu");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void openRegistration(ActionEvent actionEvent){

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/laba4_lera/registration.fxml"));
                Parent scene = fxmlLoader.load();
                Stage stage = (Stage)(registration.getScene().getWindow());
                stage.setScene(new Scene(scene));
                stage.setTitle("Registration");
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


    }




}