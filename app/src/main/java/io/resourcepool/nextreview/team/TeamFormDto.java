package io.resourcepool.nextreview.team;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
public class TeamFormDto {
  private Long id;
  @NotEmpty
  @Size(min = 3, max = 64)
  private String name;
  @NotEmpty
  private List<Long> members;
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Long> getMembers() {
    return members;
  }

  public void setMembers(List<Long> members) {
    this.members = members;
  }
}
