package com.carpopling.apirest.Person;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Person.
 * Define las operaciones de la base de datos para la entidad Person.
 * @author Fabricio Mena
 */
@Repository // Anotación que indica que esta interfaz es un componente de repositorio en Spring
public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * Busca una persona por su identificador.
     *
     * @param id Identificador de la persona a buscar.
     * @return Optional conteniendo la persona si es encontrada, o un Optional vacío si no es así.
     */
    Optional<Person> findById(Integer id);
}
