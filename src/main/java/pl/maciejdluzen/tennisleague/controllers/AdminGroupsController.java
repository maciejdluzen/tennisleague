package pl.maciejdluzen.tennisleague.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/groups")
@Slf4j
public class AdminGroupsController {

    private final AdminService adminService;

    public AdminGroupsController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("allrounds")
    public List<Round> findAllRounds() {
        List<Round> allRounds = adminService.findAllRounds();
        return allRounds;
    }

    @GetMapping
    public String prepareManageGroupsPage() {
        return "admin/groups/groups";
    }

    @GetMapping
    public String prepareNewGroupForm(Model model) {
        model.addAttribute("newGroup", new NewGroupCreationDTO());
        return "admin/groups/new-group-form";
    }

    @PostMapping
    public String processNewGroupForm(@ModelAttribute("newGroup")
      @Valid NewGroupCreationDTO newGroup, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/groups/new-group-form";
        }
        return "redirect:/";
    }
}
