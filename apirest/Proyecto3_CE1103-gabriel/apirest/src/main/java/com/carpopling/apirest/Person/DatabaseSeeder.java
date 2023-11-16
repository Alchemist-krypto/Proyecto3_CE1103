package com.carpopling.apirest.Person;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final PersonService personService;

    public DatabaseSeeder(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Llamar al método para obtener todos los empleados desde el archivo XML
        List<Person> employees = Clases.XML.obtenerTodosLosEmpleados();

        // Verificar si se obtuvieron empleados
        if (employees != null) {
            // Iterar sobre la lista de empleados y guardarlos en la base de datos uno por uno
            for (Person employee : employees) {
                personService.newPerson(employee);
            }
        }
    }
}

