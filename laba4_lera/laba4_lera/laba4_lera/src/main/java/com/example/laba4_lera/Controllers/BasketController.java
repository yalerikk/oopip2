package com.example.laba4_lera.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BasketController {
    @FXML
    private Label chek;
    @FXML
    private Label cost;
    @FXML
    private Button exit;

    @FXML
    void initialize() {

        cost.setText(String.valueOf(MenuController.sum));
        exit.setOnAction(actionEvent -> {
            cost.setText("");
            chek.setText("Оплата прошла!");
            exit.setOnAction(actionEvent1 -> {
                    Stage stage = (Stage)(exit.getScene().getWindow());
                    stage.close();
            });
        });
    }
}
