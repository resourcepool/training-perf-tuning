package io.resourcepool.nextreview.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Converts Strings to LocalTime instances.
 *
 * @author Loïc Ortola on 13/06/2017
 */
public class LocalTimeConverter implements Converter<String, LocalTime> {

  DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
    .appendOptional(DateTimeFormatter.ofPattern("h:mma"))
    .appendOptional(DateTimeFormatter.ofPattern("HH:mm"))
    .toFormatter();

  @Override
  public LocalTime convert(String s) {
    if (s == null || s.trim().isEmpty()) {
      return null;
    }
    s = s.trim().toUpperCase();
    return LocalTime.parse(s, FORMATTER);
  }

}
