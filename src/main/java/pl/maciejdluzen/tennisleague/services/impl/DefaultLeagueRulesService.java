package pl.maciejdluzen.tennisleague.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.repositories.RulesRepository;
import pl.maciejdluzen.tennisleague.services.LeagueRulesService;

@Service
@Transactional
public class DefaultLeagueRulesService implements LeagueRulesService {

    private final RulesRepository rulesRepository;

    public DefaultLeagueRulesService(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }






}
