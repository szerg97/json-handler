package com.szalai.jsonhandler.controller;

import com.szalai.jsonhandler.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    @GetMapping("")
    public Car getCar(){
        Car car = new Car("Mazda", "CX5", 5);
        car.setId(UUID.randomUUID());
        return car;
    }
}
