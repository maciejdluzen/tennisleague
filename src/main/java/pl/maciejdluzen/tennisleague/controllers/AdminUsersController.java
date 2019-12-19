package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.services.AdminService;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    private final AdminService adminService;

    public AdminUsersController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("allUsers")
    public List<User> findAllUsers() {
        return adminService.findAllUsers();
    }

    @GetMapping
    public String prepareManageUsersPage() {
        return "admin/users/users";
    }

    @GetMapping("/delete")
    public String prepareDeleteUser(Model model, Long id) {
        model.addAttribute("id", id);
        return "admin/users/delete-user";
    }

    @PostMapping("/delete")
    public String processDeleteUser(Long id) {
        adminService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/deactivateuser")
    public String deactivateUserAccount(Long id) {
        adminService.deactivateUserAccount(id);
        return "redirect:/admin/users";
    }
}
