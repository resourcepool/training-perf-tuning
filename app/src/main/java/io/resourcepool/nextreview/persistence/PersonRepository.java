package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.common.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Represents the repository for persons.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
  List<Person> findByLastNameLikeOrFirstNameLikeOrEmailLikeAllIgnoreCaseOrderByFirstNameAsc(String firstName, String lastName, String email);
}
