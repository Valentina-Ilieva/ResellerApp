package com.resellerapp.controller;

import com.resellerapp.model.dtos.OfferAddModel;
import com.resellerapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class AddOfferController {
    private final OfferService offerService;

    @Autowired
    public AddOfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/add")
    public String getAddOffer(){
        return "offer-add";
    }

    @PostMapping("/add")
    public String postOrder (@Valid @ModelAttribute(name = "offerAddModel")OfferAddModel offerAddModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddModel", offerAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddModel", bindingResult);
            return "redirect:add";
        }
        this.offerService.addOffer(offerAddModel);
        return "redirect:/home";
    }
//    @GetMapping("/ready/{id}")
//    public String ready(@PathVariable Long id){
//        orderService.readyOrder(id);
//
//        return "redirect:/home";
//
//    }

    @ModelAttribute(name = "offerAddModel")
    public OfferAddModel offerAddModel(){
        return new OfferAddModel();

    }

}
