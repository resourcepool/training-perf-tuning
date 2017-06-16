package io.resourcepool.nextreview.team.mapper;

import io.resourcepool.nextreview.common.Mapper;
import io.resourcepool.nextreview.common.model.Person;
import io.resourcepool.nextreview.common.model.Team;
import io.resourcepool.nextreview.team.TeamFormDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 12/06/2017
 */
@Component
public class TeamMapper implements Mapper<Team, TeamFormDto> {

  @Override
  public Team from(TeamFormDto o) {
    if (o == null) {
      return null;
    }
    return Team.builder()
      .id(o.getTeamId())
      .name(o.getName())
      .members(o.getMembers() == null ? null : o.getMembers().stream().map(Person::new).collect(Collectors.toList()))
      .build();
  }

}
