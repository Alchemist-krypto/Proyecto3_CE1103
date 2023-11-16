package com.carpopling.apirest.Person;
import java.util.List; // Importación correcta

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")

public class PersonController {
    private final PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }
    @GetMapping
    public List<Person> getPersons(){
        return this.personService.getPersons();
    }
    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Person person){
        return this.personService.newPerson(person);
    }
}
