package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;

import java.util.List;

public interface RankingService {

    List<SinglesPlayer> findAllByGroup(Long id);

//    List<Group> findAllWithSinglesPlayers();

    List<RankingByGroupsDTO> getAllRankings();

}
