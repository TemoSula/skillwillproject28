package com.example.skillwillproject28.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_car")
public class UserCarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "carmodel_id")
    private CarModel carModel;
    @ManyToOne
    @JoinColumn(name = "usermodel_id")
    private UserModel userModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
