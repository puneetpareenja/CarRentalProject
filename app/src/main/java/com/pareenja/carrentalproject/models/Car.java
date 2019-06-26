package com.pareenja.carrentalproject.models;

import java.util.ArrayList;

public class Car {
    String id;
    String carName;
    String brand;
    String year;
    ArrayList<CarType> carTypes;
    String Color;

    public Car(String id, String carName, String brand, String year, ArrayList<CarType> carTypes, String color) {
        this.id = id;
        this.carName = carName;
        this.brand = brand;
        this.year = year;
        this.carTypes = carTypes;
        Color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<CarType> getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(ArrayList<CarType> carTypes) {
        this.carTypes = carTypes;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
