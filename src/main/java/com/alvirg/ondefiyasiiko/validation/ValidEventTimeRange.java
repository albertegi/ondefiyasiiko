package com.alvirg.ondefiyasiiko.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EventTimeRangeValidator.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEventTimeRange {
    String message() default "VALIDATION.EVENT.TIME_RANGE.INVALID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
