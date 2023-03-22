package com.szalai.jsonhandler.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.szalai.jsonhandler.serializer.CarSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonSerialize(using = CarSerializer.class)
public class Car {
    private UUID id;
    private String brand;
    private String model;
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        this.brand = brand;
        this.model = model;
        this.numberOfDoors = numberOfDoors;
    }
}
