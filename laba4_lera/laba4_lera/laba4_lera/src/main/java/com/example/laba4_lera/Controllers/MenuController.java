package com.example.laba4_lera.Controllers;

import com.example.laba4_lera.Models.Train;

import com.example.laba4_lera.Services.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;



public class MenuController  {
    @FXML
    private Button ButtonExit;
    @FXML
    private TableView<Train> TableViewProduct;
    @FXML
    private TableView<Train> basket;
    @FXML
    private Button addProduct;
    @FXML
    private Button basketWelcome;
    @FXML
    private Button deleteProduct;
    @FXML
    private Label labelList;
    @FXML
    private Label helloLabel;

    static TrainService productService1 = new TrainService();
    static UsersService usersService = new UsersService(new CommandAdd(productService1),
                                                        new CommandDelete(productService1));
    static double sum = 0;

    @FXML
    void initialize() {
        helloLabel.setText("");
        setTable();
        setupTableColumn();
        ButtonExit.setOnAction(this::exit);
        basketWelcome.setOnAction(this::openBasket);

        addProduct.setOnAction(actionEvent -> {
            Train selectedItem = TableViewProduct.getSelectionModel().getSelectedItem();
            usersService.addRecord(selectedItem, productService1.getBasket());
            Note noteAdd = new Note(new AddActivity(), selectedItem);
            helloLabel.setText(noteAdd.activityClick());
        });

        deleteProduct.setOnAction(actionEvent -> {
            Train productItem = basket.getSelectionModel().getSelectedItem();
            usersService.deleteRecord(productItem, productService1.getBasket());
            Note noteDel = new Note(new DeleteActivity(), productItem);
            helloLabel.setText(noteDel.activityClick());
        });
    }

    private void openBasket(ActionEvent actionEvent) {
        sum = productService1.getBasket().stream().mapToDouble(x -> x.getCost()).sum();
        if(sum != 0){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/laba4_lera/basket.fxml"));
            Parent scene = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(scene));
            stage.setTitle("Basket");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}
    }


    @FXML
    void setupTableColumn() {
        TableColumn<Train, String> nameColumn =
                (TableColumn<Train, String>) TableViewProduct.getColumns().get(0);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Train, String>("number"));
        TableColumn<Train, Double> costColumn =
                (TableColumn<Train, Double>) TableViewProduct.getColumns().get(1);
        costColumn.setCellValueFactory(new PropertyValueFactory<Train, Double>("cost"));
        TableColumn<Train, String> dateTimeColumn =
                (TableColumn<Train, String>) TableViewProduct.getColumns().get(2);
        dateTimeColumn.setCellValueFactory(new PropertyValueFactory<Train, String>("dateTime"));
        TableColumn<Train, String> pathColumn =
                (TableColumn<Train, String>) TableViewProduct.getColumns().get(3);
        pathColumn.setCellValueFactory(new PropertyValueFactory<Train, String>("path"));

        TableColumn<Train, String> nameColumnB =
                (TableColumn<Train, String>) basket.getColumns().get(0);
        nameColumnB.setCellValueFactory(new PropertyValueFactory<Train, String>("number"));
        TableColumn<Train, Double> costColumnB =
                (TableColumn<Train, Double>) basket.getColumns().get(1);
        costColumnB.setCellValueFactory(new PropertyValueFactory<Train, Double>("cost"));
    }
    @FXML
    void setTable(){

        TableViewProduct.setEditable(true);
        TableViewProduct.setItems(productService1.getTimetable());

        basket.setEditable(true);
        basket.setItems(productService1.getBasket());
    }
    void exit(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/laba4_lera/authorization.fxml"));
            Parent scene = fxmlLoader.load();
            Stage stage = (Stage)(ButtonExit.getScene().getWindow());
            stage.setScene(new Scene(scene));
            stage.setTitle("Authorization");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void newTable() {
        labelList.setText("Корзина обновлена!");
    }
}

