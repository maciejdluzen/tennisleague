package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.dtos.ReportSingleMatchResultDTO;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerDetailsDTO;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;
import pl.maciejdluzen.tennisleague.services.JoinRoundService;
import pl.maciejdluzen.tennisleague.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AccountController {

    private final JoinRoundService joinRoundService;
    private final UserService userService;

    public AccountController(JoinRoundService joinRoundService, UserService userService) {
        this.joinRoundService = joinRoundService;
        this.userService = userService;
    }

    @ModelAttribute("allrounds")
    public List<Round> allRounds() {
        return joinRoundService.findAllRounds();
    }

    @ModelAttribute("registerLimit")
    public LocalDate dateToday() {
        LocalDate registerLimit = LocalDate.now().plusDays(1L);
        return registerLimit;
    }

    @ModelAttribute("soonestround")
    public Round soonestRound() {
        LocalDate dayNow = LocalDate.now().plusDays(1L);
        return userService.findFirstByStartDateAfter(dayNow);
    }

    @ModelAttribute("ntrplevels")
    public List<Double> ntrpLevels() {
        Double[] ntrp = new Double[] {1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0};
        return Arrays.asList(ntrp);
    }

    @GetMapping("/playerdetails")
    public String prepareSinglesPlayerDetailsForm(Model model) {
        model.addAttribute("singlesPlayerDetails", new SinglesPlayerDetailsDTO());
        return "/user/player-details-form";
    }

    @PostMapping("/playerdetails")
    public String processSinglesPlayerDetailsForm(@ModelAttribute("singlesPlayerDetails")
      @Valid SinglesPlayerDetailsDTO singlesPlayerDetails, BindingResult result) {
        if(result.hasErrors()) {
            return "/user/player-details-form";
        }
        userService.singlesPlayerDetails(singlesPlayerDetails);
        return "redirect:/user";
    }


    @GetMapping
    public String prepareAccountPage(Model model, Principal principal) {
        String username = principal.getName(); // tutaj chcemy sie dostac do zalogowanego uzytkownika!
        model.addAttribute("username", username);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); ALTERNATYWA
        return "user/account";
    }


    @GetMapping("/joinround2")
    public String prepareJoinRoundPage2(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        SinglesPlayerSignUpDTO singlesPlayerSignUp = joinRoundService.findSinglesPlayerByUser(user.getId());
        if (singlesPlayerSignUp == null) {
            return "redirect:/user";
        }
        if (singlesPlayerSignUp.getFirstName() == null || singlesPlayerSignUp.getLastName() == null || singlesPlayerSignUp.getPhoneNumber() == null || singlesPlayerSignUp.getNtrp() == null) {
            return "redirect:/user";
        }
        if(singlesPlayerSignUp.getRoundId() != null) {
            return "redirect:/user";
        }
        model.addAttribute("singlesPlayerSignUp", singlesPlayerSignUp);
        return "/user/round-signup-form";
    }

    @PostMapping("/joinround2")
    public String processJoinRoundPage2(@ModelAttribute @Valid SinglesPlayerSignUpDTO singlesPlayerSignUp,
                                        BindingResult result) {
        if(result.hasErrors()) {
            return "/user/round-signup-form";
        }
        joinRoundService.singlesPlayerRoundSignUp(singlesPlayerSignUp);
        return "redirect:/user";
    }

    // Poprzednie metody zapisu graczas do rundy

    @GetMapping("/joinround")
    public String prepareJoinRoundPage(Model model) {
        model.addAttribute("singlesPlayer", new SinglesPlayerSignUpDTO());
        return "/user/player-form";
    }

    @PostMapping("/joinround")
    public String processJoinRoundPage(@ModelAttribute("singlesPlayer")
        @Valid SinglesPlayerSignUpDTO singlesPlayerSignUp, BindingResult result) {
        if (result.hasErrors()) {
            return "/user/player-form";
        }
        joinRoundService.joinRound(singlesPlayerSignUp);
        return "redirect:/user";
    }

    // Przeniesione z UserMatchesController 20Dec

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

//    @GetMapping
//    public String prepareUserMatchesPage(Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        return "user/matches/playermatches";
//    }

    @GetMapping("/matches/reportresult")
    public String prepareReportMatchResultForm(Long id, Model model) {
        ReportSingleMatchResultDTO match = userService.findById(id);
        model.addAttribute("match", match);
        return "user/matches/report-result-form";
    }

    @PostMapping("/matches/reportresult")
    public String processReportMatchResultForm(@ModelAttribute
                                               @Valid ReportSingleMatchResultDTO match, BindingResult result) {
        if(result.hasErrors()) {
            return "user/matches/report-result-form";
        }
        if(match != null) {
            userService.reportSinglesMatchResult(match);
        }
        return "redirect:/user";
    }









}
