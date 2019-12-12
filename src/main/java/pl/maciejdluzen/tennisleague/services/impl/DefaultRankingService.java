package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.GroupRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;
import pl.maciejdluzen.tennisleague.services.RankingService;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultRankingService implements RankingService {

    private final SinglesPlayerRepository singlesPlayerRepository;
    private final GroupRepository groupRepository;

    public DefaultRankingService(SinglesPlayerRepository singlesPlayerRepository, GroupRepository groupRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.groupRepository = groupRepository;
    }

//    @Override
//    public List<Group> findAllWithSinglesPlayers() {
//        return groupRepository.findAllWithSinglesPlayers().stream().map(r ->
//                new ModelMapper().map(r, RankingByGroupsDTO.class)).collect(Collectors.toList());
//    }



    // Redundant:
    @Override
    public List<SinglesPlayer> findAllByGroup(Long id) {
        return singlesPlayerRepository.findAllByGroupIdOrderByTotalPointsDescTotalMatchesWonDesc(id);
    }



}
