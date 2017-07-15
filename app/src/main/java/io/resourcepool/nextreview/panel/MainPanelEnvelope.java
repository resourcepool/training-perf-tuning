package io.resourcepool.nextreview.panel;

import io.resourcepool.nextreview.common.model.Person;
import io.resourcepool.nextreview.common.model.Review;
import io.resourcepool.nextreview.common.model.Team;
import org.springframework.data.domain.Page;

/**
 * Wrapping all necessary data to display on the main dashboard.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public class MainPanelEnvelope {
  private Long teamCount;
  private Long membersCount;
  private Long scheduledReviewsCount;
  private Page<Person> members;
  private Page<Review> nextReviews;
  private Page<Team> teams;

  public Long getTeamCount() {
    return teamCount;
  }

  public void setTeamCount(Long teamCount) {
    this.teamCount = teamCount;
  }

  public Long getMembersCount() {
    return membersCount;
  }

  public void setMembersCount(Long membersCount) {
    this.membersCount = membersCount;
  }

  public Long getScheduledReviewsCount() {
    return scheduledReviewsCount;
  }

  public void setScheduledReviewsCount(Long scheduledReviewsCount) {
    this.scheduledReviewsCount = scheduledReviewsCount;
  }

  public Page<Person> getMembers() {
    return members;
  }

  public void setMembers(Page<Person> members) {
    this.members = members;
  }

  public Page<Review> getNextReviews() {
    return nextReviews;
  }

  public void setNextReviews(Page<Review> nextReviews) {
    this.nextReviews = nextReviews;
  }

  public Page<Team> getTeams() {
    return teams;
  }

  public void setTeams(Page<Team> teams) {
    this.teams = teams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MainPanelEnvelope that = (MainPanelEnvelope) o;

    if (teamCount != null ? !teamCount.equals(that.teamCount) : that.teamCount != null) return false;
    if (membersCount != null ? !membersCount.equals(that.membersCount) : that.membersCount != null)
      return false;
    if (scheduledReviewsCount != null ? !scheduledReviewsCount.equals(that.scheduledReviewsCount) : that.scheduledReviewsCount != null)
      return false;
    if (members != null ? !members.equals(that.members) : that.members != null) return false;
    if (nextReviews != null ? !nextReviews.equals(that.nextReviews) : that.nextReviews != null) return false;
    return teams != null ? teams.equals(that.teams) : that.teams == null;
  }

  @Override
  public int hashCode() {
    int result = teamCount != null ? teamCount.hashCode() : 0;
    result = 31 * result + (membersCount != null ? membersCount.hashCode() : 0);
    result = 31 * result + (scheduledReviewsCount != null ? scheduledReviewsCount.hashCode() : 0);
    result = 31 * result + (members != null ? members.hashCode() : 0);
    result = 31 * result + (nextReviews != null ? nextReviews.hashCode() : 0);
    result = 31 * result + (teams != null ? teams.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MainPanelEnvelope{" +
      "teamCount=" + teamCount +
      ", membersCount=" + membersCount +
      ", scheduledReviewsCount=" + scheduledReviewsCount +
      ", members=" + members +
      ", nextReviews=" + nextReviews +
      ", teams=" + teams +
      '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Long teamCount;
    private Long membersCount;
    private Long scheduledReviewsCount;
    private Page<Person> members;
    private Page<Review> nextReviews;
    private Page<Team> teams;

    private Builder() {
    }

    
    public Builder teamCount(Long teamCount) {
      this.teamCount = teamCount;
      return this;
    }

    public Builder membersCount(Long membersCount) {
      this.membersCount = membersCount;
      return this;
    }

    public Builder scheduledReviewsCount(Long scheduledReviewsCount) {
      this.scheduledReviewsCount = scheduledReviewsCount;
      return this;
    }

    public Builder members(Page<Person> members) {
      this.members = members;
      return this;
    }

    public Builder nextReviews(Page<Review> nextReviews) {
      this.nextReviews = nextReviews;
      return this;
    }

    public Builder teams(Page<Team> teams) {
      this.teams = teams;
      return this;
    }

    public MainPanelEnvelope build() {
      MainPanelEnvelope mainPanelEnvelope = new MainPanelEnvelope();
      mainPanelEnvelope.setTeamCount(teamCount);
      mainPanelEnvelope.setMembersCount(membersCount);
      mainPanelEnvelope.setScheduledReviewsCount(scheduledReviewsCount);
      mainPanelEnvelope.setMembers(members);
      mainPanelEnvelope.setNextReviews(nextReviews);
      mainPanelEnvelope.setTeams(teams);
      return mainPanelEnvelope;
    }
  }
}
