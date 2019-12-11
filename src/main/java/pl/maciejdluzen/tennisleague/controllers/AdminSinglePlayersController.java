package pl.maciejdluzen.tennisleague.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.dtos.EditSinglesPlayerDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/singlesplayers")
public class AdminSinglePlayersController {


    private final AdminService adminService;

    public AdminSinglePlayersController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("allsinglesplayers")
    public List<SinglesPlayer> findAllSinglesPlayers() {
        return adminService.findAllSinglesPlayers();
    }

    @ModelAttribute("allgroups")
    public List<Group> findAllGroups() {
        List<Group> allGroups = adminService.findAllGroups();
        return allGroups;
    }

    @GetMapping
    public String prepareManageSinglesPlayersPage() {
        return "admin/singlesplayers/singlesplayers";
    }

    @GetMapping("/edit")
    public String prepareEditSinglesPlayerForm(Long id, Model model) {
        EditSinglesPlayerDTO singlesPlayer = adminService.findById(id);
        model.addAttribute("singlesPlayer", singlesPlayer);
        return "admin/singlesplayers/splayer-edit-form";
    }

    @PostMapping("/edit")
    public String processEditSinglesPlayerForm(@ModelAttribute
           @Valid EditSinglesPlayerDTO singlesPlayer, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/singlesplayers/splayer-edit-form";
        }
        if(singlesPlayer != null) {
            adminService.editSinglesPlayer(singlesPlayer);
        }
        return "redirect:/admin/singlesplayers";
    }
}
