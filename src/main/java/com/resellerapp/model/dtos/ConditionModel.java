package com.resellerapp.model.dtos;

import com.resellerapp.model.enums.ConditionName;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class ConditionModel {
    private Long id;
    private ConditionName name;
    private String description;
}
