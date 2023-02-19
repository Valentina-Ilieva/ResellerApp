package com.resellerapp.vallidation.validateOffer;

import com.resellerapp.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OfferValidator implements ConstraintValidator<ValidateOffer, Long> {
private final OfferRepository offerRepository;

    @Autowired
    public OfferValidator(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public void initialize(ValidateOffer constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return this.offerRepository.findById(id).isEmpty();
    }
}
