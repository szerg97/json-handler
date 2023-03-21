package com.szalai.jsonhandler.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Address {

    private Map<String, String> map = new HashMap<>();

    public Address(String address, String zipcode, String country) {
        map.put("address", address);
        map.put("zip", zipcode);
        map.put("country", country);
    }

    @JsonAnyGetter
    public Map<String, String> getMap() {
        return map;
    }

    @JsonAnySetter
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
