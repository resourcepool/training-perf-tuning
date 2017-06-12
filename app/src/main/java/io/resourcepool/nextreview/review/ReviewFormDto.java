package io.resourcepool.nextreview.review;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
public class ReviewFormDto {
  private Long id;
  private String name;
  private String description;
  // Chosen team
  private Long teamId;
  private LocalDate scheduledDate;
  private LocalTime scheduledTime;

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

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public LocalDate getScheduledDate() {
    return scheduledDate;
  }

  public void setScheduledDate(LocalDate scheduledDate) {
    this.scheduledDate = scheduledDate;
  }

  public LocalTime getScheduledTime() {
    return scheduledTime;
  }

  public void setScheduledTime(LocalTime scheduledTime) {
    this.scheduledTime = scheduledTime;
  }
}
