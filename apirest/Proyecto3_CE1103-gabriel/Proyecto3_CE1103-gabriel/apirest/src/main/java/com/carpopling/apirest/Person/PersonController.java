package com.carpopling.apirest.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para la entidad Person.
 * Proporciona endpoints para obtener y registrar personas.
 * @author Fabricio Mena
 */
@RestController // Anotación que indica que esta clase es un controlador REST
@RequestMapping("/person") // Anotación que define la ruta base para los endpoints de esta clase
public class PersonController {
    private final PersonService personService; // Servicio que maneja la lógica de negocio para Person

    /**
     * Constructor para inyectar dependencias en el controlador.
     *
     * @param personService El servicio utilizado para operaciones relacionadas con Person.
     */
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /**
     * Endpoint para obtener una lista de todas las personas.
     *
     * @return Lista de objetos Person.
     */
    @GetMapping // Anotación que indica un método de manejo de solicitudes GET
    public List<Person> getPersons(){
        return this.personService.getPersons();
    }

    /**
     * Endpoint para registrar una nueva persona.
     *
     * @param person Objeto Person que se va a registrar.
     * @return ResponseEntity con el resultado de la operación.
     */
    @PostMapping // Anotación que indica un método de manejo de solicitudes POST
    public ResponseEntity<Object> registrar(@RequestBody Person person){
        return this.personService.newPerson(person);
    }
}
