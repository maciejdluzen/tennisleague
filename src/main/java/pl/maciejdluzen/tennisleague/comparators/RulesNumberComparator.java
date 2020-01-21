package pl.maciejdluzen.tennisleague.comparators;

import pl.maciejdluzen.tennisleague.domain.entities.Rule;

import java.util.Comparator;

public class RulesNumberComparator implements Comparator<Rule> {

    @Override
    public int compare(Rule firstRule, Rule secondRule) {
        return (firstRule.getNumber() - secondRule.getNumber());
    }
}
