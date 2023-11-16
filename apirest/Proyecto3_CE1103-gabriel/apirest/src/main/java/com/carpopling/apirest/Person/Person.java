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

@Data
@Table
@NoArgsConstructor
@Entity
public class Person {
    @Id
    
    @Column(unique = true)
    private Integer id;
    @Basic
    private String nombre;
    private String direccion;
    private String condicion;

    public Person(Integer id, String nombre, String direccion, String condicion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.condicion = condicion;
    }


}
