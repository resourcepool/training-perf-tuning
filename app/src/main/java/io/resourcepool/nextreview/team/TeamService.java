package io.resourcepool.nextreview.team;

import com.google.common.collect.Lists;
import io.resourcepool.nextreview.common.model.Team;
import io.resourcepool.nextreview.persistence.ReviewRepository;
import io.resourcepool.nextreview.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 11/06/2017
 */
@Service
public class TeamService {
  private final TeamRepository teamRepository;
  private final ReviewRepository reviewRepository;

  @Autowired
  public TeamService(TeamRepository teamRepository, ReviewRepository reviewRepository) {
    this.teamRepository = teamRepository;
    this.reviewRepository = reviewRepository;
  }
  
  public List<Team> getAll() {
    return Lists.newArrayList(teamRepository.findAll());
  }

  @Transactional
  public void save(Team team) {
    if (team.getId() == null && teamRepository.findByNameIgnoreCase(team.getName()) != null) {
      throw new EntityExistsException();
    }
    teamRepository.save(team);
  }

  @Transactional
  public void delete(Long id) {
    reviewRepository.deleteByTeamId(id);
    teamRepository.delete(id);
  }

  public Team get(Long id) {
    return teamRepository.findOne(id);
  }
}
