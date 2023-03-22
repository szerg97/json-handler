package com.szalai.jsonhandler.controller;

import com.szalai.jsonhandler.model.Car;
import com.szalai.jsonhandler.model.Car.WheelPosition;
import com.szalai.jsonhandler.model.Car.WheelSize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    @GetMapping("")
    public Car getCar(){
        Car car = new Car("Mazda", "CX5", 5, Map.of(
                WheelPosition.FL, WheelSize.MEDIUM,
                WheelPosition.FR, WheelSize.MEDIUM,
                WheelPosition.RL, WheelSize.MEDIUM,
                WheelPosition.RR, WheelSize.MEDIUM
        ));
        car.setId(UUID.randomUUID());
        return car;
    }

    @PostMapping("")
    public void addCar(
            @RequestBody Car car
    ){
        System.out.println(car);
    }
}
