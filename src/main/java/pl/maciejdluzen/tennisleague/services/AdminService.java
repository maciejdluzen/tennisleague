package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;

import java.util.List;

public interface AdminService {

    void addNewRound(NewRoundCreationDTO newRound);

    void addNewGroup(NewGroupCreationDTO newGroup);

    List<Round> findAllRounds();

}
