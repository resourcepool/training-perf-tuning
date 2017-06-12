package io.resourcepool.nextreview.review;

import io.resourcepool.nextreview.dashboard.DashboardService;
import io.resourcepool.nextreview.team.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  
  private final DashboardService dashboardService;
  private final TeamService teamService;

  @Autowired
  public AddReviewController(DashboardService dashboardService, TeamService teamService) {
    this.dashboardService = dashboardService;
    this.teamService = teamService;
  }

  @GetMapping
  public String get(Model model) {
    LOGGER.info("Getting Add Review Panel");
    model.addAttribute(ATTR_REVIEW, new ReviewFormDto());
    model.addAttribute(ATTR_TEAMS, teamService.getAll());
    return "add_review";
  }
  
  @PostMapping
  public void add(@ModelAttribute ReviewFormDto review) {
    
  }
}
