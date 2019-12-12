package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/user/matches")
public class UserMatchesController {

    private final UserService userService;

    public UserMatchesController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userMatches")
    public List<Match> findAllMatchesByUserName() {
        List<Match> userMatches = userService.findAllByUserUsername();
        return userMatches;
    }

    @GetMapping
    public String prepareUserMatchesPage(Model model) {
        return "user/matches/playermatches";
    }

}
