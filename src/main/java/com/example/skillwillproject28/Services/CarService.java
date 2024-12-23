package com.example.skillwillproject28.Services;

import com.example.skillwillproject28.Models.CarModel;
import com.example.skillwillproject28.Repositories.CarRepository;
import com.example.skillwillproject28.Request.AddCarRequest;
import com.example.skillwillproject28.Response.CarResponse;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepo;


    public CarModel addCar(AddCarRequest request)
    {
        CarModel carModel = new CarModel();
        carModel.setCarBrand(request.carBrand());
        carModel.setCarModel(request.carModel());
        carModel.setYear(request.year());
        return carRepo.save(carModel);
    }


    public List<CarResponse> getAllCars(int page, int perpage)
    {
        List<CarResponse> carResponse = carRepo.findAll(PageRequest.of(page, perpage))
                .stream().toList().stream().map(c-> new CarResponse(c.getCarModel(),c.getCarBrand(),c.getYear())).toList();
        return carResponse;
    }



}
