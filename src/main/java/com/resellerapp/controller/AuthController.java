package com.resellerapp.controller;

import com.resellerapp.model.dtos.UserLoginModel;
import com.resellerapp.model.dtos.UserRegisterModel;
import com.resellerapp.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterModel") UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel",
                            bindingResult);
            return "redirect:register";
        }

        this.authService.registerUser(userRegisterModel);
        return "redirect:login";
    }
    @GetMapping("/login")
    public String getLogin(){
        return"login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginModel") UserLoginModel userLoginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel",
                            bindingResult);
            return "redirect:login";
        }


        this.authService.loginUser(userLoginModel);

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String getLogout() {
        this.authService.logoutUser();
        return "redirect:/";
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel(){
        return new UserLoginModel();
    }


    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel(){
        return new UserRegisterModel();

    }
}
