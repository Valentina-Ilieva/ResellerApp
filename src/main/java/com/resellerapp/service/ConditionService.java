package com.resellerapp.service;

import com.resellerapp.model.dtos.ConditionModel;
import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ConditionService {
    private final ModelMapper modelMapper;
    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionService(ModelMapper modelMapper, ConditionRepository conditionRepository) {
        this.modelMapper = modelMapper;
        this.conditionRepository = conditionRepository;
    }
    @PostConstruct
    private void postConstruct(){
        if (this.conditionRepository.count()==0) {
            this.conditionRepository.saveAllAndFlush(Arrays.stream(ConditionName.values())
                    .map(values -> ConditionModel.builder()
                            .name(values)
                            .description(matchDescription(values)).build())
                    .map(conditionModel -> this.modelMapper.map(conditionModel, ConditionEntity.class)).collect(Collectors.toList()));
        }

    }

    private String matchDescription(ConditionName name){
        switch (name){
            case EXCELLENT:
                return "In perfect condition";
            case GOOD:
                return "Some signs of wear and tear or minor defects";
            case ACCEPTABLE:
                return "The item is fairly worn but continues to function properly";
            default:
                return null;
        }

    }

    public ConditionModel findByName(ConditionName name){
        return this.modelMapper.map(this.conditionRepository.findByName(name)
                .orElseThrow(), ConditionModel.class);
    }
}
