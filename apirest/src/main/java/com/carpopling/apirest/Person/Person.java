package com.carpopling.apirest.Person;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id = Integer.parseInt(Clases.XML.obtenerTextoDeEtiqueta("ID"));
    @Basic
    private String nombre = Clases.XML.obtenerTextoDeEtiqueta("nombre");
    private String direccion = Clases.XML.obtenerTextoDeEtiqueta("direccion");
    private String condicion = Clases.XML.obtenerTextoDeEtiqueta("Condicion");
}
