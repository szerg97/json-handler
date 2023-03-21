package com.szalai.jsonhandler.service;

import com.szalai.jsonhandler.model.Address;
import com.szalai.jsonhandler.model.Person;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.szalai.jsonhandler.model.Person.AgeGroup;

@Service
@Slf4j
public class PersonService {

    private final List<Person> people = new ArrayList<>();

    @PostConstruct
    public void init(){
        addOnePerson(new Person("Adam Sandler", "adam.sandler@mail.com", "+3670111", LocalDate.of(1996, 4 , 5), Person.GenderType.MALE, new Address("103. Street 15", "9987AD", "UK")));
        addOnePerson(new Person("Benedict Cucumber", "benedict.cucumber@mail.com", "+3670222", LocalDate.of(1982, 10 , 13), Person.GenderType.MALE, new Address("23. Street 15", "9987DE", "DE")));
        addOnePerson(new Person("Cecil Brown", "cecil.brown@mail.com", "+3670333", LocalDate.of(1972, 2 , 23), Person.GenderType.FEMALE, new Address("207. Street 28", "98977AD", "UK")));
        addOnePerson(new Person("Daniel Smith", "daniel.smith@mail.com", "+3670444", LocalDate.of(2005, 3 , 6), Person.GenderType.OTHER, new Address("98. Street 25", "52367AD", "US")));
        addOnePerson(new Person("Emily Dawson", "emilyy@mail.com", "+3670555", LocalDate.of(1989, 8 , 12), Person.GenderType.FEMALE, new Address("50. Street 23", "9872LE", "UK")));
    }

    public List<Person> findAllPeople(){
        return people;
    }

    public Person findOnePerson(UUID id){
        return people.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Person with id [%s] not found".formatted(id)));
    }

    public Person addOnePerson(Person person) {
        UUID id = UUID.randomUUID();
        person.setId(id);
        person.setAge(LocalDate.now().getYear() - person.getDateOfBirth().getYear());
        person.setAgeGroup(groupByAge(person));
        person.setUserName(person.getEmail().split("@")[0]);
        people.add(person);
        log.info("User - [%s] (group: %s) was added to the database.".formatted(person.getUserName(), person.getAgeGroup()));
        return people.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Person with id [%s] not found".formatted(id)));
    }

    private AgeGroup groupByAge(Person person){
        if (person.getAge() < 20){
            return AgeGroup.BELOW_TWENTY;
        }
        if (person.getAge() < 30){
            return AgeGroup.FROM_TWENTY_BELOW_THIRTY;
        }
        if (person.getAge() < 40){
            return AgeGroup.FROM_THIRTY_BELOW_FORTY;
        }
        if (person.getAge() < 50){
            return AgeGroup.FROM_FORTY_BELOW_FIFTY;
        }
        return AgeGroup.FROM_FIFTY;
    }
}
