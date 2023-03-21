package com.szalai.jsonhandler.service;

import com.szalai.jsonhandler.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.szalai.jsonhandler.model.Person.AgeGroup;

@Service
@Slf4j
public class PersonService {

    private final List<Person> people = new ArrayList<>();

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
