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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@RequestMapping({"/edit_review.html"})
@Controller
public class EditReviewController {

  private static final String ATTR_TEAMS = "teams";
  private static final String ATTR_REVIEW = "review";
  private static final Logger LOGGER = LoggerFactory.getLogger(EditReviewController.class);
  
  private final TeamService teamService;
  private final ReviewService reviewService;
  private final ReviewMapper reviewMapper;

  @Autowired
  public EditReviewController(TeamService teamService, ReviewService reviewService, ReviewMapper reviewMapper) {
    this.teamService = teamService;
    this.reviewService = reviewService;
    this.reviewMapper = reviewMapper;
  }

  @GetMapping
  public String get(@RequestParam Long id, Model model) {
    LOGGER.info("Getting Edit Review Panel");
    model.addAttribute(ATTR_REVIEW, reviewMapper.to(reviewService.get(id)));
    model.addAttribute(ATTR_TEAMS, teamService.getAll());
    return "edit_review";
  }

  @PostMapping
  public String add(@Valid @ModelAttribute(ATTR_REVIEW) ReviewFormDto review, BindingResult bindingResult, Model model) {
    LOGGER.info("Attempt to Update Review");
    if (bindingResult.hasErrors()) {
      LOGGER.warn("Error while updating review: {}", bindingResult.getAllErrors());
      model.addAttribute(ATTR_REVIEW, review);
      model.addAttribute(ATTR_TEAMS, teamService.getAll());
      return "edit_review";
    }
    reviewService.save(reviewMapper.from(review));
    return "redirect:/";
  }
}
