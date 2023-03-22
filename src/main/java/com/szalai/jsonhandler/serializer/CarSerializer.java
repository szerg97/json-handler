package com.szalai.jsonhandler.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.szalai.jsonhandler.model.Car;

import java.io.IOException;

public class CarSerializer extends JsonSerializer<Car> {

    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("car");
        jsonGenerator.writeObjectField("carId", car.getId());
        jsonGenerator.writeObjectField("carBrand", car.getBrand());
        jsonGenerator.writeObjectField("carModel", car.getModel());
        jsonGenerator.writeObjectField("numOfDoors", car.getNumberOfDoors());
    }
}
