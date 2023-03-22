package com.szalai.jsonhandler.serializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.szalai.jsonhandler.model.Car;

import java.io.IOException;

public class CarDeserializer extends JsonDeserializer<Car> {

    @Override
    public Car deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        Car car = new Car();
        car.setBrand(node.get("carBrand").asText());
        car.setModel(node.get("carModel").asText());
        car.setNumberOfDoors(node.get("numOfDoors").asInt());
        car.setWheels(node.get("wheels").requireNonNull());
        return car;
    }
}
