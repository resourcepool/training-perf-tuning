package io.resourcepool.nextreview.team;

import io.resourcepool.nextreview.person.PersonService;
import io.resourcepool.nextreview.team.mapper.TeamMapper;
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
@RequestMapping({"/edit_team.html"})
@Controller
public class EditTeamController {

  private static final String ATTR_MEMBERS = "members";
  private static final String ATTR_TEAM = "team";
  private static final Logger LOGGER = LoggerFactory.getLogger(EditTeamController.class);

  private final TeamService teamService;
  private final PersonService personService;
  private final TeamMapper teamMapper;

  @Autowired
  public EditTeamController(TeamService teamService, PersonService personService, TeamMapper teamMapper) {
    this.teamService = teamService;
    this.personService = personService;
    this.teamMapper = teamMapper;
  }

  @GetMapping
  public String get(@RequestParam Long id, Model model) {
    LOGGER.info("Getting Edit Team Panel");
    model.addAttribute(ATTR_TEAM, teamMapper.to(teamService.get(id)));
    model.addAttribute(ATTR_MEMBERS, personService.getAll());
    return "team/edit_team";
  }

  @PostMapping
  public String add(@Valid @ModelAttribute(ATTR_TEAM) TeamFormDto team, BindingResult bindingResult, Model model) {
    LOGGER.info("Attempt to Update Team");
    if (bindingResult.hasErrors()) {
      LOGGER.warn("Error while updating team: {}", bindingResult.getAllErrors());
      model.addAttribute(ATTR_TEAM, team);
      model.addAttribute(ATTR_MEMBERS, personService.getAll());
      return "team/edit_team";
    }
    teamService.save(teamMapper.from(team));
    return "redirect:/";
  }
}
