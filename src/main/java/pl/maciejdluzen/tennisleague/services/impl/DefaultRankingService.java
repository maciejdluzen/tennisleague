package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.GroupRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;
import pl.maciejdluzen.tennisleague.services.RankingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultRankingService implements RankingService {

    private final SinglesPlayerRepository singlesPlayerRepository;
    private final GroupRepository groupRepository;

    public DefaultRankingService(SinglesPlayerRepository singlesPlayerRepository, GroupRepository groupRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.groupRepository = groupRepository;
    }

    public List<RankingByGroupsDTO> getAllRankings() {
        List<Group> groups = groupRepository.findAllWithSinglesPlayersAndMatchesByOrderBySinglePlayersTotalPointsDesc();
        List<RankingByGroupsDTO> rankings = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (Group group : groups) {
            RankingByGroupsDTO ranking = mapper.map(group, RankingByGroupsDTO.class);
            List<String> playersDescription = group.getSinglePlayers().stream().map(p -> p.getFirstName() + " " + p.getLastName() + " [W" + p.getTotalMatchesWon() + ", P" + p.getTotalMatchesLost() + "] " + p.getTotalPoints() + " " + p.getNotes()).collect(Collectors.toList());
            List<Integer> playersTotalPoints = group.getSinglePlayers().stream().map(p -> p.getTotalPoints()).collect(Collectors.toList());
            List<String> matchDescription = group.getMatches().stream().filter(p -> (p.getPlayerOneSets() + p.getPlayerTwoSets()) != 0).map(p -> p.getPlayerOne().getFirstName() + " " + p.getPlayerOne().getLastName()
                    + " - " + p.getPlayerTwo().getFirstName() + " " + p.getPlayerTwo().getLastName() + " " + p.getPlayerOneSets() + " : " + p.getPlayerTwoSets()).collect(Collectors.toList());
            ranking.setPlayersTotalPoints(playersTotalPoints);
            ranking.setPlayersDescription(playersDescription);

            ranking.setMatchesDescription(matchDescription);
            rankings.add(ranking);
        }
        return rankings;
    }






    // Redundant:
    @Override
    public List<SinglesPlayer> findAllByGroup(Long id) {
        return singlesPlayerRepository.findAllByGroupIdOrderByTotalPointsDescTotalMatchesWonDesc(id);
    }



}
