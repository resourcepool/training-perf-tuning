package io.resourcepool.nextreview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

/**
 * Represents a review session.
 *
 * @author Loïc Ortola on 07/06/2017
 */
@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  @OneToOne
  private Team team;
  private ZonedDateTime scheduledDateTime;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public ZonedDateTime getScheduledDateTime() {
    return scheduledDateTime;
  }

  public void setScheduledDateTime(ZonedDateTime scheduledDateTime) {
    this.scheduledDateTime = scheduledDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Review review = (Review) o;

    if (id != null ? !id.equals(review.id) : review.id != null) return false;
    if (name != null ? !name.equals(review.name) : review.name != null) return false;
    if (description != null ? !description.equals(review.description) : review.description != null) return false;
    if (team != null ? !team.equals(review.team) : review.team != null) return false;
    return scheduledDateTime != null ? scheduledDateTime.equals(review.scheduledDateTime) : review.scheduledDateTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (team != null ? team.hashCode() : 0);
    result = 31 * result + (scheduledDateTime != null ? scheduledDateTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Review{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", team=" + team +
      ", scheduledDateTime=" + scheduledDateTime +
      '}';
  }


  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Long id;
    private String name;
    private String description;
    private Team team;
    private ZonedDateTime scheduledDateTime;

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

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder team(Team team) {
      this.team = team;
      return this;
    }

    public Builder scheduledDateTime(ZonedDateTime scheduledDateTime) {
      this.scheduledDateTime = scheduledDateTime;
      return this;
    }

    public Review build() {
      Review review = new Review();
      review.setId(id);
      review.setName(name);
      review.setDescription(description);
      review.setTeam(team);
      review.setScheduledDateTime(scheduledDateTime);
      return review;
    }
  }
}
