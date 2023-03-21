package com.szalai.jsonhandler.controller;

import com.szalai.jsonhandler.model.Person;
import com.szalai.jsonhandler.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(
            @PathVariable UUID id
    ){
        return personService.findOnePerson(id);
    }

    @GetMapping("")
    public List<Person> getPeople(){
        return personService.findAllPeople();
    }

    @PostMapping("")
    public Person addPerson(
            @RequestBody Person person
    ){
        return personService.addOnePerson(person);
    }
}
