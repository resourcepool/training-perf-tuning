package io.resourcepool.nextreview.team;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
public class TeamFormDto {
  private Long teamId;
  @NotEmpty
  @Size(min = 3, max = 64)
  private String name;
  
  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
