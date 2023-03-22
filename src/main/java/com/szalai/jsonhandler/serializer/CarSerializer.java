package com.szalai.jsonhandler.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.szalai.jsonhandler.model.Car;
import com.szalai.jsonhandler.model.Car.WheelPosition;

import java.io.IOException;

public class CarSerializer extends JsonSerializer<Car> {

    @Override
    public void serialize(Car car, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
            gen.writeObjectFieldStart("car");
                gen.writeObjectField("carId", car.getId());
                gen.writeObjectField("carBrand", car.getBrand());
                gen.writeObjectField("carModel", car.getModel());
                gen.writeObjectFieldStart("wheels");
                    gen.writeObjectFieldStart("frontLeft");
                        gen.writeObjectField("size", car.getWheels().get(WheelPosition.FL).getValue());
                    gen.writeEndObject();
                    gen.writeObjectFieldStart("frontRight");
                        gen.writeObjectField("size", car.getWheels().get(WheelPosition.FR).getValue());
                    gen.writeEndObject();
                    gen.writeObjectFieldStart("rearLeft");
                        gen.writeObjectField("size", car.getWheels().get(WheelPosition.RL).getValue());
                    gen.writeEndObject();
                    gen.writeObjectFieldStart("rearRight");
                        gen.writeObjectField("size", car.getWheels().get(WheelPosition.RR).getValue());
                    gen.writeEndObject();
                gen.writeEndObject();
                gen.writeObjectField("numOfDoors", car.getNumberOfDoors());
            gen.writeEndObject();
        gen.writeEndObject();
    }
}
