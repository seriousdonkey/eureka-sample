package de.seriousdonkey.eureka.client.data.controller;

import de.seriousdonkey.eureka.client.data.entities.PersonEntity;
import de.seriousdonkey.eureka.client.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/data/persons")
public class PersonDataController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<PersonEntity> getPersons() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/by-lastname", method = RequestMethod.GET)
    public Iterable<PersonEntity> getPersonsByLastname(@RequestParam("lastname") final String lastname) {
        return personRepository.findByLastname(lastname);
    }

}
