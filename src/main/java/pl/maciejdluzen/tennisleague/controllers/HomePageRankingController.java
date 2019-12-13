package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;
import pl.maciejdluzen.tennisleague.services.RankingService;

import java.util.List;

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
