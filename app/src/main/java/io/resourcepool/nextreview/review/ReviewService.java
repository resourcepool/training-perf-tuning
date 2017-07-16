package io.resourcepool.nextreview.review;

import io.resourcepool.nextreview.common.model.Review;
import io.resourcepool.nextreview.persistence.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 13/06/2017
 */
@Service
public class ReviewService {
  
  private final ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }
  
  public void save(Review review) {
    reviewRepository.save(review);
  }

  public Review get(Long id) {
    return reviewRepository.findOne(id);
  }

  public void delete(Long id) {
    reviewRepository.delete(id);
  }

  public Page<Review> getAll(PageRequest request) {
    return reviewRepository.findByScheduledDateTimeAfter(ZonedDateTime.now(), request);
  }
}
