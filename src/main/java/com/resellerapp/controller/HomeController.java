package com.resellerapp.controller;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final LoggedUser loggedUser;

    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
@Autowired
    public HomeController(LoggedUser loggedUser, UserRepository userRepository, OfferRepository offerRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }
    @GetMapping("home")
    public ModelAndView getHome(ModelAndView modelAndView){
        User logged = this.userRepository.findById(loggedUser.getId()).get();
        List<Offer> userOffers = logged.getOffers();

        modelAndView.setViewName("home");
        modelAndView.addObject("username", logged.getUsername());
        modelAndView.addObject("userWithOffers", userOffers);

        return modelAndView;
    }

}
