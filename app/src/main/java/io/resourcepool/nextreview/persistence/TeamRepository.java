package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.common.model.Team;
import org.springframework.data.repository.CrudRepository;

/**
 * Represents the repository for teams.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
  Team findByNameIgnoreCase(String name);
}
