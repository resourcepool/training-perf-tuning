package io.resourcepool.nextreview.review;

import io.resourcepool.nextreview.common.validation.Future;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
public class ReviewFormDto {
  private Long id;
  @Size(min = 3, max = 64)
  private String name;
  @Size(min = 3, max = 255)
  private String description;
  // Chosen team
  @Min(value = 1, message = "a team must be selected")
  private Long teamId;
  @Future
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate scheduledDate;
  
  @NotNull(message = "this field is mandatory")
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
