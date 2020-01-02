package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.dtos.RankingByGroupsDTO;

import java.time.LocalDate;
import java.util.List;

public interface RankingService {

    List<SinglesPlayer> findAllByGroup(Long id);

    List<RankingByGroupsDTO> getAllRankings();

    Round findCurrentRound();

    List<Round> findAllFutureRounds(LocalDate dateNow);

    List<Round> findAllPreviousRounds(LocalDate dateNow);

    RankingByGroupsDTO getGroupRanking(Long id);

}
