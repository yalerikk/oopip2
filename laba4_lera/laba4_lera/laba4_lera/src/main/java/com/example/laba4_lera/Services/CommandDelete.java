package com.example.laba4_lera.Services;

import com.example.laba4_lera.Controllers.MenuController;
import com.example.laba4_lera.Models.Train;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class CommandDelete implements Command{
        TrainService trainService;

    public CommandDelete(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Train product, ObservableList<Train> observableList) {
        trainService.delete(product, observableList);
    }
}
