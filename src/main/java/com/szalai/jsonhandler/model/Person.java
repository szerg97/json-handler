package com.szalai.jsonhandler.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        "address",
        "dateOfBirth",
        "gender",
        "age",
        "registered"
})
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Person {

    @JsonProperty(
            access = READ_ONLY,
            value = "personId"
    )
    private UUID id;
    @JsonProperty(value = "fullName")
    private String name;
    @JsonProperty(value = "emailAddress")
    private String email;
    @JsonProperty(value = "phoneNumber")
    private String phone;
    @JsonProperty(access = WRITE_ONLY)
    private LocalDate dateOfBirth;
    @JsonProperty(access = READ_ONLY)
    private int age;
    private GenderType gender;
    @JsonProperty(value = "residenceInformation")
    private Address address;
    private AgeGroup ageGroup;
    private String userName;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm"
    )
    @JsonProperty(value = "registeredAt")
    private LocalDateTime registered = LocalDateTime.now();

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
