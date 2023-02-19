package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.vallidation.validateOffer.ValidateOffer;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class OfferAddModel {
    @NotNull
    @Positive
    private BigDecimal price;


    @NotNull
    private String description;

    @NotNull
    private ConditionName condition;
}
