package com.carpopling.apirest.Person;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa una entidad "Person" en la base de datos.
 * Utiliza anotaciones de Lombok para generar automáticamente constructores y métodos.
 * También utiliza anotaciones de JPA para mapear la entidad a una tabla en la base de datos.
 * @author Fabricio Mena
 */
@Data           // Lombok annotation for getters, setters, equals, hashCode, and toString methods
@Table          // JPA annotation to indicate this class is an entity stored in a table
@NoArgsConstructor // Lombok annotation for no-argument constructor
@Entity         // JPA annotation to denote an entity in the database
public class Person {
    @Id // JPA annotation to denote the primary key
    @Column(unique = true) // JPA annotation to denote a unique column in the database
    private Integer id;
    @Basic // JPA annotation to denote a basic attribute of the entity
    private String nombre;
    private String direccion;
    private String condicion;

    /**
     * Constructor de la clase Person.
     *
     * @param id         Identificador único de la persona.
     * @param nombre     Nombre de la persona.
     * @param direccion  Dirección de la persona.
     * @param condicion  Condición de la persona.
     */
    public Person(Integer id, String nombre, String direccion, String condicion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.condicion = condicion;
    }
}
