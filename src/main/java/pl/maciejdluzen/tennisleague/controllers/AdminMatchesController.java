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
import pl.maciejdluzen.tennisleague.dtos.EditMatchDTO;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewMatchCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/matches")
public class AdminMatchesController {

    private final AdminService adminService;

    public AdminMatchesController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("sets")
    public List<Integer> sets() {
        Integer[] sets = new Integer[]{0,1,2};
        return Arrays.asList(sets);
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
      @Valid NewMatchCreationDTO newMatch, BindingResult result){
        if(result.hasErrors()) {
            return "admin/matches/new-match-form";
        }
        adminService.addNewMatch(newMatch);
        return "redirect:/admin/matches";
    }

    @GetMapping("/delete")
    public String prepareDeleteMatch(Long id) {
        adminService.deleteMatchById(id);
        return "redirect:/admin/matches";
    }

    @GetMapping("/edit")
    public String prepareEditMatchForm(Long id, Model model) {
        EditMatchDTO editMatch = adminService.findMatchById(id);
        model.addAttribute("editMatch", editMatch);
        return "admin/matches/edit-match-form";
    }

    @PostMapping("/edit")
    public String processEditMatchForm(@ModelAttribute @Valid EditMatchDTO editMatch, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/matches/edit-match-form";
        }
        adminService.editMatch(editMatch);
        return "redirect:/admin/matches";
    }
}
