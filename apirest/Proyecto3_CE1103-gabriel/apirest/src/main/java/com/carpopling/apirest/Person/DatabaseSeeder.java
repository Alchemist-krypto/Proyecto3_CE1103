package com.carpopling.apirest.Person;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Clase que se encarga de poblar la base de datos al inicio de la aplicación.
 * Implementa CommandLineRunner para ejecutar código después de iniciar la aplicación Spring Boot.\
 * 
 * @author Fabricio Mena
 */
@Component // Anotación que denota un componente gestionado por Spring
public class DatabaseSeeder implements CommandLineRunner {

    private final PersonService personService; // Servicio para operaciones relacionadas con Person

    /**
     * Constructor para DatabaseSeeder.
     * 
     * @param personService Servicio para gestionar operaciones de personas.
     */
    public DatabaseSeeder(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Método ejecutado al inicio de la aplicación para poblar la base de datos.
     * 
     * @param args Argumentos de línea de comandos.
     * @throws Exception Si ocurre algún error durante la ejecución.
     */
    @Override
    public void run(String... args) throws Exception {
        // Obtiene una lista de empleados desde un archivo XML
        List<Person> employees = Clases.XML.obtenerTodosLosEmpleados();

        // Si se obtienen empleados, los guarda en la base de datos
        if (employees != null) {
            for (Person employee : employees) {
                personService.newPerson(employee); // Guarda cada empleado en la base de datos
            }
        }
    }
}
