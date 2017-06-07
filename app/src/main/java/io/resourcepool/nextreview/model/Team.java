package io.resourcepool.nextreview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Represents a project team.
 *
 * @author Loïc Ortola on 07/06/2017
 */
@Entity
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToMany
  private List<Person> members;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Person> getMembers() {
    return members;
  }

  public void setMembers(List<Person> members) {
    this.members = members;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Team team = (Team) o;

    if (id != null ? !id.equals(team.id) : team.id != null) return false;
    return members != null ? members.equals(team.members) : team.members == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (members != null ? members.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Team{" +
      "id='" + id + '\'' +
      ", members=" + members +
      '}';
  }
}
