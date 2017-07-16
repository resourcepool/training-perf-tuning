package io.resourcepool.nextreview.panel;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;

/**
 * This wrapper parses a request object and generates the page request content for each entity.
 *
 * @author Loïc Ortola on 15/07/2017
 */
public class MainPanelPageRequest {

  private static final int DEFAULT_PERSON_PAGE_SIZE = 10;
  private static final int DEFAULT_TEAM_PAGE_SIZE = 8;
  private static final int DEFAULT_REVIEW_PAGE_SIZE = 3;

  private PageRequest personPageRequest;
  private PageRequest teamPageRequest;
  private PageRequest reviewPageRequest;

  private MainPanelPageRequest() {

  }

  public PageRequest getPersonPageRequest() {
    return personPageRequest;
  }

  public PageRequest getReviewPageRequest() {
    return reviewPageRequest;
  }

  public PageRequest getTeamPageRequest() {
    return teamPageRequest;
  }

  public static MainPanelPageRequest parse(HttpServletRequest request) {
    MainPanelPageRequest r = new MainPanelPageRequest();
    int personPage = getValidPageOrDefault(request, "personPage");
    r.personPageRequest = new PageRequest(personPage, DEFAULT_PERSON_PAGE_SIZE, Sort.Direction.ASC, "firstName");
    int teamPage = getValidPageOrDefault(request, "teamPage");
    r.teamPageRequest = new PageRequest(teamPage, DEFAULT_TEAM_PAGE_SIZE, Sort.Direction.ASC, "name");
    int reviewPage = getValidPageOrDefault(request, "reviewPage");
    r.reviewPageRequest = new PageRequest(reviewPage, DEFAULT_REVIEW_PAGE_SIZE, Sort.Direction.ASC, "scheduledDateTime");
    return r;
  }

  private static int getValidPageOrDefault(HttpServletRequest request, String param) {
    String parameter = request.getParameter(param);
    if (parameter != null && !parameter.trim().isEmpty() && isValidNumber(parameter)) {
      return Integer.parseInt(parameter);
    }
    return 0;
  }

  private static boolean isValidNumber(String s) {
    return s != null && s.matches("\\d+");
  }
}
