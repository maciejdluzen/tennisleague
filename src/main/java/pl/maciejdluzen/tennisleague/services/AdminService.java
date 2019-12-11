package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;

public interface AdminService {

    void addNewRound(NewRoundCreationDTO newRound);

}
