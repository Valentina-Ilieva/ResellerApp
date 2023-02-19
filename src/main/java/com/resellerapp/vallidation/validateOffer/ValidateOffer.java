package com.resellerapp.vallidation.validateOffer;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = OfferValidator.class)
public @interface ValidateOffer {
    String message() default "Offer name is taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
