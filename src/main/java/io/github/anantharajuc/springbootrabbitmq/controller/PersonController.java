package io.github.anantharajuc.springbootrabbitmq.controller;

import io.github.anantharajuc.springbootrabbitmq.model.Person;
import io.github.anantharajuc.springbootrabbitmq.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/")
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person)
    {
        personServiceImpl.createPerson(person);
    }
}
