package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;

import java.util.List;

public interface JoinRoundService {

    void joinRound(SinglesPlayerSignUpDTO singlesPlayer);

    List<Round> findAllRounds();


}
