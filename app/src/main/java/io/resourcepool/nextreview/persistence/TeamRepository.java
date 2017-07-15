package io.resourcepool.nextreview.persistence;

import io.resourcepool.nextreview.common.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Represents the repository for teams.
 *
 * @author Loïc Ortola on 07/06/2017
 */
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
  Team findByNameIgnoreCase(String name);
}
