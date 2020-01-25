package pl.maciejdluzen.tennisleague.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.maciejdluzen.tennisleague.domain.entities.VerificationToken;
import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;
import pl.maciejdluzen.tennisleague.services.RegistrationService;
import pl.maciejdluzen.tennisleague.services.VerificationTokenService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final VerificationTokenService verificationTokenService;

    public RegistrationController(RegistrationService registrationService, VerificationTokenService verificationTokenService) {
        this.registrationService = registrationService;
        this.verificationTokenService = verificationTokenService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "register/form";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("registrationData") // w nawiaskie mamy wartosc bo ("registrationData", new RegistrationDataDTO()) w getRegistrationPage
      @Valid RegistrationDataDTO registrationData, BindingResult results) {
        if (results.hasErrors()) {
            return "register/form";
        }
        try {
            registrationService.register(registrationData);
        } catch (ConstraintViolationException cve) {
            for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
                String field = null;
                for (Path.Node node : violation.getPropertyPath()) {
                    field = node.getName();
                }
                results.rejectValue(field, violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName() + ".registrationData." + field);
            }
            return "register/form";
        }
        return "login";
    }

    @GetMapping("/confirmation")
    public String processConfirmRegistration(@RequestParam("token") String token) {
        VerificationToken verificationToken = verificationTokenService.findByToken(token);

        if(verificationToken != null) {
            registrationService.makeUserStatusActive(verificationToken.getUser().getId());
        } else {
            return "register/failed-activation";
        }
        return "register/complete-activation";
    }
}
