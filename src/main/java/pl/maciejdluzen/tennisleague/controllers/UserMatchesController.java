package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.dtos.ReportSingleMatchResultDTO;
import pl.maciejdluzen.tennisleague.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user/matches")
public class UserMatchesController {

    private final UserService userService;

    public UserMatchesController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("sets")
    public List<Integer> sets() {
        Integer[] sets = new Integer[]{0,1,2};
        return Arrays.asList(sets);
    }

    @ModelAttribute("userMatches")
    public List<Match> findAllMatchesByUserName() {
        List<Match> userMatches = userService.findAllByUserUsername();
        return userMatches;
    }

    @GetMapping
    public String prepareUserMatchesPage(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "user/matches/playermatches";
    }

    @GetMapping("/reportresult")
    public String prepareReportMatchResultForm(Long id, Model model) {
        ReportSingleMatchResultDTO match = userService.findById(id);
        model.addAttribute("match", match);
        return "user/matches/report-result-form";
    }

    @PostMapping("/reportresult")
    public String processReportMatchResultForm(@ModelAttribute
       @Valid ReportSingleMatchResultDTO match, BindingResult result) {
        if(result.hasErrors()) {
            return "user/matches/report-result-form";
        }
        if(match != null) {
            userService.reportSinglesMatchResult(match);
        }
        return "redirect:/user/matches";
    }
}
