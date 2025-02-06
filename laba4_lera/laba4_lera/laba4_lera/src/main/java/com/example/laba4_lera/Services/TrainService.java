package com.example.laba4_lera.Services;

import com.example.laba4_lera.Models.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;

public class TrainService {

    private ObservableList<Train> products;
    private ObservableList<Train> basket;
    public static String string;



    public TrainService(){
        basket = FXCollections.observableArrayList();


        products= FXCollections.observableArrayList(
                new Train("HP210902", 43, "2024-01-19, 09:00","Минск-Лунец"),
                new Train("KS211101", 34, "2024-01-20, 12:00","Минск-Микашевичи"),
                new Train("AKK12345", 40, "2024-01-21, 09:20","Минск-Гомель"),
                new Train("LP483943", 66, "2024-01-29, 10:00","Минск-Новогрудок"),
                new Train("ABS00483", 58, "2024-01-18, 11:30","Минск-Жлобин")
                );
    }
    public ObservableList<Train> getTimetable(){
        return products;
    }

    public ObservableList<Train> getBasket() {return basket;}

    public void add(Train product, ObservableList<Train> observableList) {
        observableList.add(product);
    }

    public void delete(Train product, ObservableList<Train> observableList) {
        Iterator<Train> productIterator =  observableList.iterator();
        while (productIterator.hasNext()){
            Train nextProduct = productIterator.next();
            if(nextProduct.equals(product)){
                productIterator.remove();
                break;
            }
        }
    }
}
