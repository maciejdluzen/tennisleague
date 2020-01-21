package pl.maciejdluzen.tennisleague.services;


import pl.maciejdluzen.tennisleague.domain.entities.Rule;

import java.util.List;

public interface LeagueRulesService {

    List<Rule> getAllRules();
}
