package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Represents the repository for persons.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
