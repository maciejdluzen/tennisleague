package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
