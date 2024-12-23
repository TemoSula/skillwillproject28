package com.example.skillwillproject28.Response;

public class UserCarCartsResponse {
    private String yourUsername;
    private String carBrand;
    private String carModel;
    private int year;

    public UserCarCartsResponse(String yourUsername, String carBrand, String carModel, int year) {
        this.yourUsername = yourUsername;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
    }

    public UserCarCartsResponse() {
    }

    public String getYourUsername() {
        return yourUsername;
    }

    public void setYourUsername(String yourUsername) {
        this.yourUsername = yourUsername;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
