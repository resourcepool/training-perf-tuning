package io.resourcepool.nextreview.person;

import io.resourcepool.nextreview.person.mapper.PersonMapper;
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
@RequestMapping({"/add_person.html"})
@Controller
public class AddPersonController {

  private static final String ATTR_TEAMS = "teams";
  private static final String ATTR_PERSON = "person";
  private static final Logger LOGGER = LoggerFactory.getLogger(AddPersonController.class);
  
  private final TeamService teamService;
  private final PersonService personService;
  private final PersonMapper personMapper;
  
  @Autowired
  public AddPersonController(TeamService teamService, PersonService personService, PersonMapper personMapper) {
    this.personService = personService;
    this.teamService = teamService;
    this.personMapper = personMapper;
  }

  @GetMapping
  public String get(Model model) {
    LOGGER.info("Getting Add Person Panel");
    model.addAttribute(ATTR_PERSON, new PersonFormDto());
    model.addAttribute(ATTR_TEAMS, teamService.getAll());
    return "person/add_person";
    
  }

  @PostMapping
  public String add(@Valid @ModelAttribute(ATTR_PERSON) PersonFormDto person, BindingResult bindingResult, Model model) {
    LOGGER.info("Attempt to Add Person");
    if (bindingResult.hasErrors()) {
      LOGGER.warn("Error while adding person: {}", bindingResult.getAllErrors());
      model.addAttribute(ATTR_PERSON, person);
      model.addAttribute(ATTR_TEAMS, teamService.getAll());
      return "person/add_person";
    }
    personService.save(personMapper.from(person));
    return "redirect:/";
  }
}
