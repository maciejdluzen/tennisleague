package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.dtos.RuleDTO;
import pl.maciejdluzen.tennisleague.services.TextService;

import java.util.List;

@Controller
@RequestMapping("/admin/rules")
public class AdminRulesController {

    private final TextService textService;

    public AdminRulesController(TextService textService) {
        this.textService = textService;
    }

    @ModelAttribute("allrules")
    public List<Rule> findAllRules() {
        List<Rule> allRules = textService.findAllRules();
        return allRules;
    }

    @GetMapping
    public String prepareAdminRulesPage(Model model) {
        model.addAttribute("newRule", new RuleDTO());
        return "admin/rules/rules";
    }
}
