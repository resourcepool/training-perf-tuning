package io.resourcepool.nextreview.person.mapper;

import io.resourcepool.nextreview.common.Mapper;
import io.resourcepool.nextreview.common.model.Person;
import io.resourcepool.nextreview.common.model.Team;
import io.resourcepool.nextreview.person.PersonFormDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 16/06/2017
 */
@Component
public class PersonMapper implements Mapper<Person, PersonFormDto> {
  
  @Override
  public Person from(PersonFormDto o) {
    if (o == null) {
      return null;
    }
    return Person.builder()
      .email(o.getEmail())
      .firstName(o.getFirstName())
      .lastName(o.getLastName())
      .teams(o.getTeams() == null ? null : o.getTeams().stream()
        .map(Team::new)
        .collect(Collectors.toList()))
      .build();
  }

}
