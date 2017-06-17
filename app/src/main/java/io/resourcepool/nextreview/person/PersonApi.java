package io.resourcepool.nextreview.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@RequestMapping({"/api/person"})
@RestController
public class PersonApi {

  private static final Logger LOGGER = LoggerFactory.getLogger(PersonApi.class);
  
  private final PersonService personService;
  
  @Autowired
  public PersonApi(PersonService personService) {
    this.personService = personService;
  }

  @DeleteMapping("/{id}")
  public void get(@PathVariable Long id) {
    LOGGER.info("Removing person");
    personService.delete(id);
    
  }

}
