package io.resourcepool.nextreview.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.Temporal;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 13/06/2017
 */
public class FutureValidator implements ConstraintValidator<Future, Temporal> {
  @Override
  public void initialize(Future constraintAnnotation) {
    
  }

  @Override
  public boolean isValid(Temporal value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    LocalDate ld = LocalDate.from(value);
    LocalDate today = LocalDate.now();
    if (ld.isEqual(today) || ld.isAfter(today)) {
      return true;
    }
    return false;
  }
  
  
}
