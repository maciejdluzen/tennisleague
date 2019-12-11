package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewMatchCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/matches")
public class AdminMatchesController {

    private final AdminService adminService;

    public AdminMatchesController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("allmatches")
    public List<Match> findAllMatches() {
        List<Match> allMatches = adminService.findAllMatches();
        return allMatches;
    }

    @ModelAttribute("allgroups")
    public List<Group> findAllGroups() {
        List<Group> allGroups = adminService.findAllGroups();
        return allGroups;
    }

    @ModelAttribute("allsinglesplayers")
    public List<SinglesPlayer> findAllSinglesPlayers() {
        List<SinglesPlayer> allSinglesPlayers = adminService.findAllSinglesPlayers();
        return allSinglesPlayers;
    }

    @GetMapping
    public String prepareManageMatchesPage() {
        return "admin/matches/matches";
    }

    @GetMapping("/add")
    public String prepareNewMatchForm(Model model) {
        model.addAttribute("newMatch", new NewMatchCreationDTO());
        return "admin/matches/new-match-form";
    }

    @PostMapping("/add")
    public String processNewMatchForm(@ModelAttribute("newMatch")
      @Valid NewGroupCreationDTO newMatch, BindingResult result){
        if(result.hasErrors()) {
            return "admin/matches/new-match-form";
        }



        return "";
    }



}
