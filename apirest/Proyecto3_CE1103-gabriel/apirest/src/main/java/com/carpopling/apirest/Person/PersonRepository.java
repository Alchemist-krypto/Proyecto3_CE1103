package com.carpopling.apirest.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
    Optional<Person> findById(Integer id);
}
