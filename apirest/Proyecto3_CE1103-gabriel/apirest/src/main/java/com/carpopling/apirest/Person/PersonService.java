package com.carpopling.apirest.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Person.
 * Proporciona funcionalidades para obtener y agregar personas en la base de datos.
 * @author Fabricio Mena
 */
@Service // Anotación que indica que esta clase es un componente de servicio en Spring
public class PersonService {
    private final PersonRepository personRepository; // Repositorio para operaciones de la base de datos

    /**
     * Constructor para inyectar dependencias del repositorio.
     *
     * @param personRepository Repositorio para operaciones con Person.
     */
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    /**
     * Obtiene una lista de todas las personas.
     *
     * @return Lista de objetos Person.
     */
    public List<Person> getPersons(){
        return this.personRepository.findAll();
    }

    /**
     * Agrega una nueva persona a la base de datos.
     * Verifica que el identificador sea único y tenga 4 dígitos.
     *
     * @param person Objeto Person a agregar.
     * @return ResponseEntity con el resultado de la operación.
     */
    public ResponseEntity<Object> newPerson(Person person) {
        Optional<Person> res = personRepository.findById(person.getId());
        HashMap<String, Object> datos = new HashMap<>();
        
        // Verifica si ya existe una persona con el mismo ID
        if(res.isPresent()){
            datos.put("Error", true);
            datos.put("message", "Ya existe ese identificador");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        // Guarda la persona si el ID tiene 4 dígitos
        if(999 < person.getId() && person.getId() < 10000){
            personRepository.save(person);
            datos.put("data", person);
            datos.put("message", "Se registró el identificador");
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }

        // Caso de error si el ID no tiene 4 dígitos
        datos.put("message", "El identificador debe ser de 4 dígitos");
        return new ResponseEntity<>(datos, HttpStatus.BAD_REQUEST);
    }
}
