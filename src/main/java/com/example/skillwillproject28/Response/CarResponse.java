package com.example.skillwillproject28.Response;

public class CarResponse {
    private String carModel;
    private String carBrand;
    private int year;

    public CarResponse(String carModel, String carBrand, int year) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.year = year;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
