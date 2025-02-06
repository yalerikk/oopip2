package com.example.laba4_lera.Services;

import com.example.laba4_lera.Models.Train;
import javafx.collections.ObservableList;

public class CommandAdd implements Command{
    TrainService trainService;

    public CommandAdd(TrainService trainService) {
        this.trainService = trainService;
    }

    @Override
    public void execute(Train product, ObservableList<Train> observableList) {
        trainService.add(product, observableList);
    }
}
