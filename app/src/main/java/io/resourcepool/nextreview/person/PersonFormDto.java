package io.resourcepool.nextreview.person;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
public class PersonFormDto {
  
  private Long id;
  @Size(min = 2, max = 64)
  private String firstName;
  @Size(min = 3, max = 64)
  private String lastName;
  @Email
  private String email;
  private List<Long> teams;
  
  public PersonFormDto() {
    this.teams = new ArrayList<>();
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Long> getTeams() {
    return teams;
  }

  public void setTeams(List<Long> teams) {
    this.teams = teams;
  }
}
