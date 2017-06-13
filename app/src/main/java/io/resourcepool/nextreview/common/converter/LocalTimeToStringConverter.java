package io.resourcepool.nextreview.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Converts LocalTime instances to String.
 *
 * @author Loïc Ortola on 13/06/2017
 */
public class LocalTimeToStringConverter implements Converter<LocalTime, String> {

  DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("h:mma");

  @Override
  public String convert(LocalTime s) {
    if (s == null) {
      return null;
    }
    return s.format(FORMATTER);
  }

}
