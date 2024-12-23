package com.example.skillwillproject28.Controllers;

import com.example.skillwillproject28.Models.CarModel;
import com.example.skillwillproject28.Request.AddCarRequest;
import com.example.skillwillproject28.Response.CarResponse;
import com.example.skillwillproject28.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public CarModel addCar(@RequestBody AddCarRequest request)
    {
        return carService.addCar(request);
    }

    @GetMapping("/getAllCars")
    public List<CarResponse> getAllCars(@RequestParam int page, @RequestParam int perpage)
    {
        return carService.getAllCars(page, perpage);
    }
}
