package com.resellerapp.model.dtos;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OfferModel {
    private Long id;
    private BigDecimal price;
    private String description;
    private ConditionModel condition;
    private UserModel seller;
    private UserModel buyer;
}
