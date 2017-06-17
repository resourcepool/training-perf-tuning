package io.resourcepool.nextreview.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Review API.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@RequestMapping({"/api/review"})
@RestController
public class ReviewApi {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReviewApi.class);
  
  private final ReviewService reviewService;
  
  @Autowired
  public ReviewApi(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @DeleteMapping("/{id}")
  public void get(@PathVariable Long id) {
    LOGGER.info("Removing review");
    reviewService.delete(id);
    
  }

}
