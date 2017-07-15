package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.common.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.ZonedDateTime;

/**
 * Represents the repository for reviews.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

  /**
   * @param scheduledDateTime the present moment
   * @param request the page request
   * @return the 3 next reviews in time
   */
  Page<Review> findByScheduledDateTimeAfter(ZonedDateTime scheduledDateTime, Pageable request);
  
  /**
   * @param scheduledDateTime the present moment
   * @return the count of remaining reviews
   */
  Long countByScheduledDateTimeAfter(ZonedDateTime scheduledDateTime);

  /**
   * @param id the team id
   */
  void deleteByTeamId(Long id);
}
