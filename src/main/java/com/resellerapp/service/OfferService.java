package com.resellerapp.service;

import com.resellerapp.model.dtos.OfferAddModel;
import com.resellerapp.model.dtos.OfferModel;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final OfferRepository offerRepository;
    private final ConditionService conditionService;
    private final UserService userService;

    @Autowired
    public OfferService(ModelMapper modelMapper, LoggedUser loggedUser, OfferRepository offerRepository, ConditionService conditionService, UserService userService) {
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.offerRepository = offerRepository;
        this.conditionService = conditionService;
        this.userService = userService;
    }
    public void addOffer (OfferAddModel offerAddModel){

        Offer offerToSave = this.modelMapper.map(OfferModel.builder()
                .price(offerAddModel.getPrice())
                .description(offerAddModel.getDescription())
                .condition(this.conditionService.findByName(offerAddModel.getCondition()))
                .seller(this.userService.findById(this.loggedUser.getId()))
                .build(), Offer.class);

        this.offerRepository.saveAndFlush(offerToSave);
    }
}
