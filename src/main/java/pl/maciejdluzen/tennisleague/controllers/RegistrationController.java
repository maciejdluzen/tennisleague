package pl.maciejdluzen.tennisleague.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;
import pl.maciejdluzen.tennisleague.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "register/form";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("registrationData") // w nawiaskie mamy wartosc bo
      @Valid RegistrationDataDTO registrationData, BindingResult results) {
        if (results.hasErrors()) {
            return "register/form";
        }

        registrationService.register(registrationData);
        return "redirect:/";
    }






}
