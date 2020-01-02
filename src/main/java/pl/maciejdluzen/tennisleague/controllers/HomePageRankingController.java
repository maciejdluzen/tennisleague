package pl.maciejdluzen.tennisleague.controllers;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;
import pl.maciejdluzen.tennisleague.services.RankingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/ranking")
public class HomePageRankingController {

    private final RankingService rankingService;

    public HomePageRankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @ModelAttribute("ranking")
    public List<RankingByGroupsDTO> singlesPlayersRankingByGroup() {
        List<RankingByGroupsDTO> ranking = rankingService.getAllRankings();
        return ranking;
    }

    @ModelAttribute("futureRounds")
    public List<Round> findAllFutureRounds() {
        List<Round> futureRounds = rankingService.findAllFutureRounds(LocalDate.now());
        return futureRounds;
    }

    @ModelAttribute("previousRounds")
    public List<Round> findAllPreviousRounds() {
        List<Round> previousRounds = rankingService.findAllPreviousRounds(LocalDate.now());
        return previousRounds;
    }

    @ModelAttribute("currentRound")
    public Round findCurrentRound() {
        Round currentRound = rankingService.findCurrentRound();
        return currentRound;
    }

    @GetMapping
    public String prepareRankingPage() {
        return "mainpage/ranking";
    }

//    public String showSinglesPlayersRankingByGroup(Model model) {
//        List<RankingByGroupsDTO> ranking = rankingService.getAllRankings();
//        model.addAttribute("ranking", ranking);
//        return "mainpage/ranking";
//    }

}
