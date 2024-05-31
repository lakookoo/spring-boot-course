package com.ltf.javagram;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  UsernameValidator.class)
public @interface Username {


    String message() default "INVALID USERNAME";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
