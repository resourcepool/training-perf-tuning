package io.resourcepool.nextreview.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 13/06/2017
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FutureValidator.class)
@Documented
public @interface Future {
  
  String message() default "date may not be empty or in the past";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
