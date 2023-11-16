package com.carpopling.apirest.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import lombok.RequiredArgsConstructor;

@Service

public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    
    public List<Person> getPersons(){
		return this.personRepository.findAll();
    }
    public ResponseEntity<Object> newPerson(Person person) {
        Optional<Person> res = personRepository.findById(person.getId());
        HashMap<String, Object> datos = new HashMap<>();
        
        if(res.isPresent()){
            datos.put("Error",true);
            datos.put("message","Ya existe ese identificador");
            return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT);
        }
        if(999<person.getId() && person.getId()<10000){
            personRepository.save(person);
            datos.put("data",datos);
            datos.put("message","Se registro el identificador");
            return new ResponseEntity<>(
                person,
                HttpStatus.CREATED
            );
        }
        datos.put("message", "El identificador debe ser de 4 digitos");
        return new ResponseEntity<>(
            datos,
            HttpStatus.CONFLICT);
    }
} 
