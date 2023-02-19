package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class ConditionEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionName name;

    @Column(nullable = false)
    private String description;

}
