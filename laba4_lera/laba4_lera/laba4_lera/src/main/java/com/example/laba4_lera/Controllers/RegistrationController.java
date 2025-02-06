package com.example.laba4_lera.Controllers;


import com.example.laba4_lera.Exception.RegException;
import com.example.laba4_lera.Services.UsersService;
import com.example.laba4_lera.Exception.UsersException;
import com.example.laba4_lera.Exception.UsersExistException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class RegistrationController {

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldPasswordOne;

    @FXML
    private Button buttonRegistration;

    @FXML
    private Label passwordMessage;

    @FXML
    private TextField showPasswordField;

    @FXML
    private PasswordField textFieldPasswordTwo;

    @FXML
    private Label passwordMessageTwo;

    @FXML
    private Label loginMessage;

    @FXML
    private RadioButton conditions;
    @FXML
    private TextField showPasswordField1;

    @FXML
    void initialize() {
        showPasswordField.setVisible(false);
        showPasswordField1.setVisible(false);
        conditions.setOnAction(actionEvent -> {
            if(conditions.isSelected()){
                showPasswordField.setText(textFieldPasswordTwo.getText());
                showPasswordField.setVisible(true);
                textFieldPasswordTwo.setVisible(false);

                showPasswordField1.setText(textFieldPasswordOne.getText());
                showPasswordField1.setVisible(true);
                textFieldPasswordOne.setVisible(false);}


                if (!conditions.isSelected()){
                    textFieldPasswordTwo.setText(showPasswordField.getText());
                    showPasswordField.setVisible(false);
                    textFieldPasswordTwo.setVisible(true);

                    textFieldPasswordOne.setText(showPasswordField1.getText());
                    showPasswordField1.setVisible(false);
                    textFieldPasswordOne.setVisible(true);
                    }


        });
        buttonRegistration.setOnAction(actionEvent -> {
            try {
                if (!textFieldLogin.getText().isEmpty() && !textFieldPasswordOne.getText().isEmpty() && !textFieldPasswordTwo.getText().isEmpty()) {
                    if (!UsersService.checkRightRegistration(textFieldPasswordOne.getText().trim(), textFieldPasswordTwo.getText().trim())) {
                        throw new UsersException();

                    }
                    if(UsersService.checkUsers(textFieldPasswordOne.getText().trim(), textFieldLogin.getText().trim())){
                        throw new UsersExistException();
                    }
                    if (!regValidation(textFieldLogin.getText(), textFieldPasswordOne.getText())){
                        throw new RegException();
                    }
                        UsersService.registration(textFieldPasswordOne.getText().trim(),textFieldLogin.getText().trim());
                        openAuthorization();
                }

            }catch (UsersException e){
                textFieldPasswordOne.setStyle("-fx-border-color: red");
                textFieldPasswordTwo.setStyle("-fx-border-color: red");
                passwordMessage.setText("Пароли не совпадают");
                passwordMessageTwo.setText("");
            }
            catch (UsersExistException e){
                textFieldPasswordOne.setStyle("-fx-border-color: red");
                textFieldPasswordTwo.setStyle("-fx-border-color: 0");
                textFieldLogin.setStyle("-fx-border-color: red");
                loginMessage.setText("Такой пользователь уже существует");
                passwordMessage.setText("");
            }
            catch (RegException e){
                textFieldPasswordOne.setStyle("-fx-border-color: red");
                textFieldPasswordTwo.setStyle("-fx-border-color: 0");
                loginMessage.setText("Пароль или логин содержит менее 6 символов");
                passwordMessage.setText("");
            }
        });
    }

    void openAuthorization(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/laba4_lera/authorization.fxml"));
            Parent scene = fxmlLoader.load();
            Stage stage = (Stage)(buttonRegistration.getScene().getWindow());
            stage.setScene(new Scene(scene));
            stage.setTitle("Menu");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    boolean regValidation(String login, String password){
        String reg = "^.{6,}$";
        System.out.println(Pattern.matches(reg,login));
        System.out.println(Pattern.matches(reg, password));
        return Pattern.matches(reg,login) && Pattern.matches(reg, password);
    }

}
