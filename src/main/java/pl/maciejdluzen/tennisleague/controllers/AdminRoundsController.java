package pl.maciejdluzen.tennisleague.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/rounds")
@Slf4j
public class AdminRoundsController {

    private final AdminService adminService;

    public AdminRoundsController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping
    public String prepareManageRoundsPage() {
        return "admin/rounds/rounds";
    }

    @GetMapping("/add")
    public String prepareNewRoundForm(Model model) {
        model.addAttribute("newRound", new NewRoundCreationDTO());
        return "admin/rounds/new-round-form";
    }

    @PostMapping("/add")
    public String processNewRoundForm(@ModelAttribute("newRound") @Valid NewRoundCreationDTO newRound,
                                      BindingResult result) {
        if (result.hasErrors()) {
            log.info("Nieprawidłowe dane rundy: " + newRound);
            return "admin/rounds/new-round-form";
        }
        log.info("Dane rundy do zapisu: " + newRound);
        adminService.addNewRound(newRound);
        return "redirect:/";
    }

}
