package com.carpopling.apirest;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de una aplicación Spring Boot para API REST.
 * 
 * @author Fabricio Mena
 * Esta clase inicia la aplicación utilizando Spring Boot, que simplifica la configuración y el despliegue de la aplicación.
 */
@SpringBootApplication // Anotación que indica una aplicación Spring Boot
public class ApirestApplication {

    /**
     * Punto de entrada principal de la aplicación Spring Boot.
     * 
     * @param args Argumentos de línea de comandos pasados al iniciar la aplicación.
     */
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(ApirestApplication.class, args);
    }
}
