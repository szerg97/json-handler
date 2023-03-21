package com.szalai.jsonhandler;

import com.szalai.jsonhandler.model.Address;
import com.szalai.jsonhandler.model.Person;
import com.szalai.jsonhandler.service.PersonService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class JsonHandlerApplication {

    private final PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(JsonHandlerApplication.class, args);
    }

    @PostConstruct
    public void init(){
        personService.addOnePerson(new Person(
                "Adam Sandler",
                "adam.sandler@mail.com",
                "+3670111",
                LocalDate.of(1996, 4 , 5),
                Person.GenderType.MALE,
                new Address("103. Street 15", "9987AD", "UK")));
        personService.addOnePerson(new Person(
                "Benedict Cucumber",
                "benedict.cucumber@mail.com",
                "+3670222",
                LocalDate.of(1982, 10 , 13),
                Person.GenderType.MALE,
                new Address("23. Street 15", "9987DE", "DE")));
        personService.addOnePerson(new Person(
                "Cecil Brown",
                "cecil.brown@mail.com",
                "+3670333",
                LocalDate.of(1972, 2 , 23),
                Person.GenderType.FEMALE,
                new Address("207. Street 28", "98977AD", "UK")));
        personService.addOnePerson(new Person(
                "Daniel Smith",
                "daniel.smith@mail.com",
                "+3670444",
                LocalDate.of(2005, 3 , 6),
                Person.GenderType.OTHER,
                new Address("98. Street 25", "52367AD", "US")));
        personService.addOnePerson(new Person(
                "Emily Dawson",
                "emilyy@mail.com",
                "+3670555",
                LocalDate.of(1989, 8 , 12),
                Person.GenderType.FEMALE,
                new Address("50. Street 23", "9872LE", "UK")));
    }
}
