package com.example.laba4_lera.Services;

import com.example.laba4_lera.Models.Train;


public class Note {
    Activity activity;
    Train product;

    public Note(Activity activity, Train product) {
        this.activity = activity;
        this.product = product;
    }

    public String activityClick(){
        return activity.note(product);}
}
