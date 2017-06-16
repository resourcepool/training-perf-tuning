package io.resourcepool.nextreview.dashboard;

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
  private static final int PAGE_SIZE = 10;
  
  private final DashboardService service;

  @Autowired
  public MainPanelController(DashboardService service) {
    this.service = service;
  }

  @GetMapping
  public String get(@RequestParam(defaultValue = "0") int page, Model model) {
    LOGGER.info("Getting Main Panel");
    model.addAttribute(ATTR_ENVELOPE, service.getMainPanel(new PageRequest(page, PAGE_SIZE, Sort.Direction.ASC, "firstName")));
    return "index";
  }
}
