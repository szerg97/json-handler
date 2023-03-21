package com.szalai.jsonhandler.controller;

import com.szalai.jsonhandler.model.Person;
import com.szalai.jsonhandler.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
