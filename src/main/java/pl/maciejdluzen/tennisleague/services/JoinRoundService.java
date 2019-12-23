package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;

import java.util.List;

public interface JoinRoundService {

    void joinRound(SinglesPlayerSignUpDTO singlesPlayer);

    List<Round> findAllRounds();


    SinglesPlayer findSinglesPlayerById(Long id);
}
