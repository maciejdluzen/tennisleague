package pl.maciejdluzen.tennisleague.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.services.AdminService;

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

    @GetMapping
    public String prepareManageSinglesPlayersPage() {
        return "admin/singlesplayers/singlesplayers";
    }








}
