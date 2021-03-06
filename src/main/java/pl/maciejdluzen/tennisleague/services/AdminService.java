package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.*;
import pl.maciejdluzen.tennisleague.dtos.*;

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

    void deleteMatchById(Long id);

    void editMatch(EditMatchDTO matchDTO);

    EditMatchDTO findMatchById(Long id);

    void deleteGroupById(Long id);

    void editGroup(EditGroupDTO groupDTO);

    EditGroupDTO findGroupById(Long id);

    void deleteRoundById(Long id);

    EditRoundDTO findRoundById(Long id);

    void editRound(EditRoundDTO roundDTO);

    List<User> findAllUsers();

    void deleteUserById(Long id);

    User findUserById(Long id);

    SinglesPlayer findSinglesPlayerById(Long id);

    void deleteSinglesPlayerById(Long id);

    void deactivateUserAccount(Long id);

    void activateUserAccount(Long id);
}
