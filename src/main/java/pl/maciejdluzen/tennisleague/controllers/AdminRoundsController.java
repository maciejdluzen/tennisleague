package pl.maciejdluzen.tennisleague.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.EditRoundDTO;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/rounds")
@Slf4j
public class AdminRoundsController {

    private final AdminService adminService;

    public AdminRoundsController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("allrounds")
    public List<Round> findAllRounds() {
        List<Round> allRounds = adminService.findAllRounds();
        return allRounds;
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

            return "admin/rounds/new-round-form";
        }

        adminService.addNewRound(newRound);
        return "redirect:/admin/rounds";
    }

    @GetMapping("/delete")
    public String prepareDeleteRound(Model model, Long id) {
        model.addAttribute("id", id);
        return "admin/rounds/delete-round";
    }

    @PostMapping("/delete")
    public String processDeleteRound(Long id) {
        adminService.deleteRoundById(id);
        return "redirect:/admin/rounds";
    }

    @GetMapping("/edit")
    public String prepareEditRoundForm(Long id, Model model) {
        EditRoundDTO roundDTO = adminService.findRoundById(id);
        model.addAttribute("roundDTO", roundDTO);
        return "admin/rounds/edit-round-form";
    }

    @PostMapping("/edit")
    public String processEditRoundForm(@ModelAttribute @Valid EditRoundDTO roundDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/rounds/edit-round-form";
        }
        adminService.editRound(roundDTO);
        return "redirect:/admin/rounds";
    }
}
