package io.resourcepool.nextreview.person;

import io.resourcepool.nextreview.common.model.Person;
import io.resourcepool.nextreview.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 12/06/2017
 */
@Service
public class PersonService {
  
  private static final int MIN_SEARCH_LENGTH = 3;
  
  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }
  
  public List<Person> findAll(String searchString) {
    if (searchString.length() < MIN_SEARCH_LENGTH) {
      return null;
    }
    // TODO what about this homemade fulltext search engine?
    String[] keywords = searchString.split("[\\s,;]");
    Set<Person> people = new HashSet<>();
    boolean isFirstKeyword = true;
    // For each keyword, look for matches in current DB. Merge them by hand
    for (String keyword : keywords) {
      String str = keyword.trim();
      List<Person> entries = personRepository.findByLastNameLikeOrFirstNameLikeOrEmailLikeAllIgnoreCaseOrderByFirstNameAsc(str, str, str);
      
      if (isFirstKeyword && entries != null && !entries.isEmpty()) {
        // First keyword returned matches. Add them all
        people.addAll(entries);
        continue;
      } else if (isFirstKeyword) {
        // First keyword returned no match. No need to investigate further
        return null;
      }
      isFirstKeyword = false;
      
      // For all remaining keywords, we are only subsetting the previous content
      Iterator<Person> it = people.iterator();
      while (it.hasNext()) {
        Person p = it.next();
        if (!entries.contains(p)) {
          people.remove(p);
        }
      }
    }
    return new ArrayList<>(people);
  }
}
