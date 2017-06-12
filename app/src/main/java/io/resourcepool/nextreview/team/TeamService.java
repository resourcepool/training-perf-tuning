package io.resourcepool.nextreview.team;

import com.google.common.collect.Lists;
import io.resourcepool.nextreview.common.model.Team;
import io.resourcepool.nextreview.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@Service
public class TeamService {
  private final TeamRepository teamRepository;

  @Autowired
  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }
  
  public List<Team> getAll() {
    return Lists.newArrayList(teamRepository.findAll());
  }

  public void save(Team team) {
    if (teamRepository.findByNameIgnoreCase(team.getName()) != null) {
      throw new EntityExistsException();
    }
    teamRepository.save(team);
  }
}
