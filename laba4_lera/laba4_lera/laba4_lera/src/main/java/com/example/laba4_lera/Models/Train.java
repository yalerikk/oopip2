package com.example.laba4_lera.Models;

public class Train {
    private String number;
    private double cost;
    private String dateTime;
    private String path;

    public Train(String number, double cost, String dateTime, String path) {
        this.number = number;
        this.cost = cost;
        this.dateTime = dateTime;
        this.path = path;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
