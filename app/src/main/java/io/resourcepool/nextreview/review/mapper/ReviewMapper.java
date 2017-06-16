package io.resourcepool.nextreview.review.mapper;

import io.resourcepool.nextreview.common.Mapper;
import io.resourcepool.nextreview.common.model.Review;
import io.resourcepool.nextreview.common.model.Team;
import io.resourcepool.nextreview.review.ReviewFormDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 13/06/2017
 */
@Component
public class ReviewMapper implements Mapper<Review, ReviewFormDto> {
  
  @Override
  public Review from(ReviewFormDto o) {
    if (o == null) {
      return null;
    }
    return Review.builder()
      .id(o.getId())
      .name(o.getName())
      .description(o.getDescription())
      .team(Team.builder().id(o.getTeamId()).build())
      .scheduledDateTime(o.getScheduledDate().atTime(o.getScheduledTime()).atZone(ZoneOffset.UTC))
      .build();
  }

}
