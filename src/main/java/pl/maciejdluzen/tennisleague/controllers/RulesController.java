package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciejdluzen.tennisleague.comparators.RulesNumberComparator;
import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.services.LeagueRulesService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/leaguerules")
public class RulesController {

    private final LeagueRulesService leagueRulesService;

    public RulesController(LeagueRulesService leagueRulesService) {
        this.leagueRulesService = leagueRulesService;
    }

    @GetMapping
    public String getRulesPage() {
        return "mainpage/leaguerules";
    }

    @ModelAttribute("allrules")
    public List<Rule> findAllRules() {
        List<Rule> rules = leagueRulesService.getAllRules();
        RulesNumberComparator rulesComparator = new RulesNumberComparator();
        Collections.sort(rules, rulesComparator);
        return rules;
    }
}
