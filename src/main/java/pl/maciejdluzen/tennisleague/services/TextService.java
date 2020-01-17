package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Rule;
import pl.maciejdluzen.tennisleague.dtos.RuleDTO;

import java.util.List;

public interface TextService {

    void addNewRule(RuleDTO newRule);

    List<Rule> findAllRules();
}
