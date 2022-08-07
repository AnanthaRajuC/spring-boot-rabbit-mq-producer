package io.github.anantharajuc.springbootrabbitmq.repository;

import io.github.anantharajuc.springbootrabbitmq.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
