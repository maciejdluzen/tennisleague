package pl.maciejdluzen.tennisleague.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.domain.repositories.RulesRepository;
import pl.maciejdluzen.tennisleague.dtos.RuleDTO;
import pl.maciejdluzen.tennisleague.services.TextService;

@Service
@Transactional @Slf4j
public class DefaultTextService implements TextService {

    private final RulesRepository rulesRepository;

    public DefaultTextService(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }

    @Override
    public void addNewRule(RuleDTO newRule) {
        ModelMapper mapper = new ModelMapper();
        Rule rule = mapper.map(newRule, Rule.class);
        rulesRepository.save(rule);
    }
}
