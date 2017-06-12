package io.resourcepool.nextreview.common.model;

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
  private String name;
  @ManyToMany
  private List<Person> members;

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
    if (name != null ? !name.equals(team.name) : team.name != null) return false;
    return members != null ? members.equals(team.members) : team.members == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (members != null ? members.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Team{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", members=" + members +
      '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Long id;
    private String name;
    private List<Person> members;

    private Builder() {
    }

    
    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder members(List<Person> members) {
      this.members = members;
      return this;
    }

    public Team build() {
      Team team = new Team();
      team.setId(id);
      team.setName(name);
      team.setMembers(members);
      return team;
    }
  }
}
