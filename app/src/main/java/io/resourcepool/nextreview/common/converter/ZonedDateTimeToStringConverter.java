package io.resourcepool.nextreview.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Converts LocalTime instances to String.
 *
 * @author Loïc Ortola on 13/06/2017
 */
public class ZonedDateTimeToStringConverter implements Converter<ZonedDateTime, String> {

  DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("eee dd h:mma");

  @Override
  public String convert(ZonedDateTime s) {
    if (s == null) {
      return null;
    }
    return s.format(FORMATTER);
  }

}
