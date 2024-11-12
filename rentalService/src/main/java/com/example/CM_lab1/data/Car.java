package com.example.CM_lab1.data;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String plateNumber;
    int price;
    String brand;
    Boolean rented = false;

    List<Dates> dates = new ArrayList<Dates>();

    // Constructors

    public Car(String plateNumber, int price, String brand) {
        this.plateNumber = plateNumber;
        this.price = price;
        this.brand = brand;
    }

    public Car() {
    }

    // Getters and Setters

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public List<Dates> getDates() {
        return dates;
    }

    public boolean addDates(Dates dates) {
        return this.dates.add(dates);
    }

    // marche pas
    public boolean removeDates(Dates dates) {
        return this.dates.remove(dates);
    }
}
