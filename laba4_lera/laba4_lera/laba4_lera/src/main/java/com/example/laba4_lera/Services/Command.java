package com.example.laba4_lera.Services;

import com.example.laba4_lera.Models.Train;
import javafx.collections.ObservableList;

public interface Command {
    void execute(Train product, ObservableList<Train> observableList);
}
