package de.seriousdonkey.eureka.client.data.repositories;

import de.seriousdonkey.eureka.client.data.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    Iterable<PersonEntity> findByLastname(final String lastname);

}
