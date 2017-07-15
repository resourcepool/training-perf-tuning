package io.resourcepool.nextreview.panel;

import io.resourcepool.nextreview.persistence.PersonRepository;
import io.resourcepool.nextreview.persistence.ReviewRepository;
import io.resourcepool.nextreview.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * This service allows to fetch all necessary data for the administration dashboards.
 *
 * @author Loïc Ortola on 07/06/2017
 */
@Service
public class DashboardService {
  
  private final PersonRepository personRepository;
  private final ReviewRepository reviewRepository;
  private final TeamRepository teamRepository;

  @Autowired
  public DashboardService(PersonRepository personRepository, ReviewRepository reviewRepository, TeamRepository teamRepository) {
    this.personRepository = personRepository;
    this.reviewRepository = reviewRepository;
    this.teamRepository = teamRepository;
  }

  /**
   * Retrieve main panel data.
   * @param request the page request
   * @return the panel data
   */
  public MainPanelEnvelope getMainPanel(MainPanelPageRequest request) {
    ZonedDateTime now = ZonedDateTime.now();
    return MainPanelEnvelope.builder()
      .members(personRepository.findAll(request.getPersonPageRequest()))
      .membersCount(personRepository.count())
      .teams(teamRepository.findAll(request.getTeamPageRequest()))
      .teamCount(teamRepository.count())
      //.nextReviews(reviewRepository.findFirst3ByScheduledDateTimeAfterOrderByScheduledDateTimeAsc(now))
        .nextReviews(reviewRepository.findByScheduledDateTimeAfter(now, request.getReviewPageRequest()))
      .scheduledReviewsCount(reviewRepository.countByScheduledDateTimeAfter(now))
      .build();
  }
}
