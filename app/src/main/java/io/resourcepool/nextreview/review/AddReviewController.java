package io.resourcepool.nextreview.review;

import io.resourcepool.nextreview.review.mapper.ReviewMapper;
import io.resourcepool.nextreview.team.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@RequestMapping({"/add_review.html"})
@Controller
public class AddReviewController {

  private static final String ATTR_TEAMS = "teams";
  private static final String ATTR_REVIEW = "review";
  private static final Logger LOGGER = LoggerFactory.getLogger(AddReviewController.class);
  
  private final TeamService teamService;
  private final ReviewService reviewService;
  private final ReviewMapper reviewMapper;

  @Autowired
  public AddReviewController(TeamService teamService, ReviewService reviewService, ReviewMapper reviewMapper) {
    this.teamService = teamService;
    this.reviewService = reviewService;
    this.reviewMapper = reviewMapper;
  }

  @GetMapping
  public String get(Model model) {
    LOGGER.info("Getting Add Review Panel");
    model.addAttribute(ATTR_REVIEW, new ReviewFormDto());
    model.addAttribute(ATTR_TEAMS, teamService.getAll());
    return "review/add_review";
  }

  @PostMapping
  public String add(@Valid @ModelAttribute(ATTR_REVIEW) ReviewFormDto review, BindingResult bindingResult, Model model) {
    LOGGER.info("Attempt to Add Review");
    if (bindingResult.hasErrors()) {
      LOGGER.warn("Error while adding review: {}", bindingResult.getAllErrors());
      model.addAttribute(ATTR_REVIEW, review);
      model.addAttribute(ATTR_TEAMS, teamService.getAll());
      return "review/add_review";
    }
    reviewService.save(reviewMapper.from(review));
    return "redirect:/";
  }
}
