package com.alvirg.ondefiyasiiko.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.METHOD}) // @Target is where we can use this annotation. whether on field or method level
@Retention(RetentionPolicy.RUNTIME) // @Retention is where it will get executed. RUNTIME when the application is running
@Constraint(validatedBy = EmailDomainValidator.class)
public @interface NonDisposableEmail {

    String message() default "Disposal email addresses are not allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
