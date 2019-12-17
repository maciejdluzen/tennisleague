package pl.maciejdluzen.tennisleague.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.EditGroupDTO;
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

    @ModelAttribute("allgroups")
    public List<Group> findAllGroups() {
        List<Group> allGroups = adminService.findAllGroups();
        return allGroups;
    }

    @GetMapping
    public String prepareManageGroupsPage() {
        return "admin/groups/groups";
    }

    @GetMapping("/add")
    public String prepareNewGroupForm(Model model) {
        model.addAttribute("newGroup", new NewGroupCreationDTO());
        return "admin/groups/new-group-form";
    }

    @PostMapping("/add")
    public String processNewGroupForm(@ModelAttribute("newGroup")
      @Valid NewGroupCreationDTO newGroup, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/groups/new-group-form";
        }
        adminService.addNewGroup(newGroup);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String prepareDeleteGroup(Long id) {
        adminService.deleteGroupById(id);
        return "redirect:/admin/groups";
    }

    @GetMapping("/edit")
    public String prepareEditGroupForm(Model model) {
        model.addAttribute("editGroup", new EditGroupDTO());
        return "admin/groups/edit-group-form";
    }



}
