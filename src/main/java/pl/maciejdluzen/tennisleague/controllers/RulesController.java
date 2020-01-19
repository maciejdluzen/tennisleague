package pl.maciejdluzen.tennisleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaguerules")
public class RulesController {

    @GetMapping
    public String getRulesPage() {
        return "mainpage/leaguerules";
    }

}
