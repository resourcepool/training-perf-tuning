package io.resourcepool.nextreview.dashboard;

import io.resourcepool.nextreview.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 07/06/2017
 */
@RequestMapping({"", "/"})
@Controller
public class MainPanelController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainPanelController.class);
  private static final String ATTR_ENVELOPE = "panel";
  private static final String ATTR_REVIEWS = "reviews";
  private static final int PAGE_SIZE = 10;
  private static final String DASHBOARD_SIZE = "5"; 
  
  private final DashboardService service;
  private final ReviewService reviewService;

  @Autowired
  public MainPanelController(DashboardService service, ReviewService reviewService) {
    this.service = service;
    this.reviewService = reviewService;
  }

  @GetMapping
  public String getAdminPanel(@RequestParam(defaultValue = "0") int page, Model model) {
    LOGGER.info("Getting Admin Panel");
    model.addAttribute(ATTR_ENVELOPE, service.getMainPanel(new PageRequest(page, PAGE_SIZE, Sort.Direction.ASC, "firstName")));
    return "dashboard/admin";
  }
  
  @GetMapping("/dashboard")
  public String getDashboard(@RequestParam(defaultValue = DASHBOARD_SIZE) int count, Model model) {
    LOGGER.info("Getting Dashboard");
    model.addAttribute(ATTR_REVIEWS, reviewService.getAll(new PageRequest(0, count, Sort.Direction.ASC, "scheduledDateTime")));
    return "dashboard/dashboard";
  }
}
