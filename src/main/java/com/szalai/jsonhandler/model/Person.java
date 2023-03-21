package com.szalai.jsonhandler.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {
        "userName",
        "ageGroup"
})
@JsonPropertyOrder(value = {
        "id",
        "name",
        "email",
        "phone",
        "dateOfBirth",
        "gender"
})
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Person {

    @JsonProperty(access = READ_ONLY, value = "personId")
    private UUID id;
    private String name;
    private String email;
    private String phone;
    @JsonProperty(access = WRITE_ONLY)
    private LocalDate dateOfBirth;
    @JsonProperty(access = READ_ONLY)
    private int age;
    private GenderType gender;
    private Address address;
    private AgeGroup ageGroup;
    private String userName;

    public Person(String name, String email, String phone, LocalDate dateOfBirth, GenderType gender, Address address) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public enum GenderType {
        MALE("male"),
        FEMALE("female"),
        OTHER("other"),
        @JsonEnumDefaultValue UNKNOWN("unknown")
        ;

        @JsonValue
        private final String value;

        GenderType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum AgeGroup {
        BELOW_TWENTY,
        FROM_TWENTY_BELOW_THIRTY,
        FROM_THIRTY_BELOW_FORTY,
        FROM_FORTY_BELOW_FIFTY,
        FROM_FIFTY
    }
}
