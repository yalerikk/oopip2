package com.example.laba4_lera.Services;
import com.example.laba4_lera.Models.Train;

public class AddActivity implements Activity {
    private String string;
    @Override
    public String note(Train product) {
        return string = "Вы зарегистрировались на рейс поезда " + product.getNumber();
    }
}
