package com.szalai.jsonhandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.szalai.jsonhandler.serializer.CarDeserializer;
import com.szalai.jsonhandler.serializer.CarSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonSerialize(using = CarSerializer.class)
//@JsonDeserialize(using = CarDeserializer.class)
public class Car {
    private UUID id;
    @JsonProperty(value = "carBrand")
    private String brand;
    @JsonProperty(value = "carModel")
    private String model;
    private int numberOfDoors;
    private Map<WheelPosition, WheelSize> wheels;
    private String qualifier;

    public Car(String brand, String model, int numberOfDoors, Map<WheelPosition, WheelSize> wheels) {
        this.brand = brand;
        this.model = model;
        this.numberOfDoors = numberOfDoors;
        this.qualifier = brand + " " + model;
        this.wheels = wheels;
    }

    public enum WheelPosition {
        FR("frontRight"),
        FL("frontLeft"),
        RR("rearRight"),
        RL("frontLeft");

        private final String value;

        WheelPosition(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum WheelSize {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large"),
        EXTRA_LARGE("extraLarge");

        private String value;

        WheelSize(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
