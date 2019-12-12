package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.dtos.EditSinglesPlayerDTO;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewMatchCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;

import java.util.List;

public interface AdminService {

    void addNewRound(NewRoundCreationDTO newRound);

    void addNewGroup(NewGroupCreationDTO newGroup);

    void editSinglesPlayer(EditSinglesPlayerDTO singlesPlayerDTO);

    void addNewMatch(NewMatchCreationDTO newMatch);

    List<Round> findAllRounds();

    List<Group> findAllGroups();

    List<SinglesPlayer> findAllSinglesPlayers();

    EditSinglesPlayerDTO findById(Long id);

    List<Match> findAllMatches();
}
