package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.common.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Represents the repository for reviews.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface ReviewRepository extends CrudRepository<Review, Long> {

  /**
   * @param scheduledDateTime the present moment
   * @return the 3 next reviews in time
   */
  List<Review> findFirst3ByScheduledDateTimeAfterOrderByScheduledDateTimeAsc(ZonedDateTime scheduledDateTime);

  /**
   * @param scheduledDateTime the present moment
   * @return the count of remaining reviews
   */
  Long countByScheduledDateTimeAfter(ZonedDateTime scheduledDateTime);
}
