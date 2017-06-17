package io.resourcepool.nextreview.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Team API.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@RequestMapping({"/api/team"})
@RestController
public class TeamApi {

  private static final Logger LOGGER = LoggerFactory.getLogger(TeamApi.class);
  
  private final TeamService teamService;
  
  @Autowired
  public TeamApi(TeamService teamService) {
    this.teamService = teamService;
  }

  @DeleteMapping("/{id}")
  public void get(@PathVariable Long id) {
    LOGGER.info("Removing team");
    teamService.delete(id);
    
  }

}
