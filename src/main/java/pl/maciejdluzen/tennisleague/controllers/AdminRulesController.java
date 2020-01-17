package pl.maciejdluzen.tennisleague.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.dtos.RuleDTO;
import pl.maciejdluzen.tennisleague.services.TextService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/rules")
@Slf4j
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

    @PostMapping
    public String processNewRule(@ModelAttribute("newRule") @Valid RuleDTO newRule, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/rules/rules";
        }
        textService.addNewRule(newRule);
        return "redirect:/admin/rules";
    }
}
