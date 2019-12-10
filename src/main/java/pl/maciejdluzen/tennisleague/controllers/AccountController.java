package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AccountController {

    @ModelAttribute("ntrplevels")
    public List<Double> ntrpLevels() {
        Double[] ntrp = new Double[] {1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0};
        return Arrays.asList(ntrp);
    }

    @GetMapping
    public String prepareAccountPage(Principal principal) {
        String username = principal.getName(); // tutaj chcemy sie dostac do zalogowanego uzytkownika!

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); ALTERNATYWA
        return "user/account";
    }

    @GetMapping("/account/joinround")
    public String prepareJoinRoundPage(Model model) {
        model.addAttribute("singlesPlayer", new SinglesPlayerSignUpDTO());
        return "/user/player-form";
    }

    @PostMapping("/account/joinround")
    public String processJoinRoundPage(@ModelAttribute("singlesPlayer")
        @Valid SinglesPlayerSignUpDTO singlesPlayerSignUp, BindingResult result) {
        if (result.hasErrors()) {
            return "/user/player-form";
        }
        return "user/account";
    }








}
