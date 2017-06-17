package io.resourcepool.nextreview.common.util;

/**
 * String utils.
 *
 * @author Loïc Ortola on 17/06/2017
 */
public class StringUtils {

  /**
   * Capitalizes a String changing the first letter to title case and trimming the word.
   * capitalize(null)  = null
   * capitalize("")    = ""
   * capitalize(" d ")    = "d"
   * capitalize("cat") = "Cat"
   * capitalize("cAt") = "CAt"
   * @param s the input string
   * @return the capitalized string
   */
  public static String capitalize(String s) {
    if (s == null) {
      return null;
    }
    if (s.trim().isEmpty()) {
      return s.trim();
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }
}
