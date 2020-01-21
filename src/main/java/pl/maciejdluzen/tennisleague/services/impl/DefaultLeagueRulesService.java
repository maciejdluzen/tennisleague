package pl.maciejdluzen.tennisleague.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.domain.repositories.RulesRepository;
import pl.maciejdluzen.tennisleague.dtos.RuleDTO;
import pl.maciejdluzen.tennisleague.services.LeagueRulesService;

import java.util.List;

@Service
@Transactional
public class DefaultLeagueRulesService implements LeagueRulesService {

    private final RulesRepository rulesRepository;

    public DefaultLeagueRulesService(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }

    public List<Rule> getAllRules() {
        List<Rule> rules = rulesRepository.findAll();
        return rules;
    }
}
