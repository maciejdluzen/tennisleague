package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.GroupRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;
import pl.maciejdluzen.tennisleague.services.RankingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultRankingService implements RankingService {

    private final SinglesPlayerRepository singlesPlayerRepository;
    private final GroupRepository groupRepository;

    public DefaultRankingService(SinglesPlayerRepository singlesPlayerRepository, GroupRepository groupRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.groupRepository = groupRepository;
    }

    // napisane przez Michała:
    public List<RankingByGroupsDTO> getAllRankings() {
        List<Group> groups = groupRepository.findAllWithSinglesPlayersBy();
        List<RankingByGroupsDTO> rankings = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (Group group : groups) {
            RankingByGroupsDTO ranking = mapper.map(group, RankingByGroupsDTO.class);
            List<String> playersFullNames = group.getSinglePlayers().stream().map(p -> p.getFirstName() + " " + p.getLastName()).collect(Collectors.toList());
            ranking.setPlayersFullNames(playersFullNames);
            rankings.add(ranking);
        }
        return rankings;
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
