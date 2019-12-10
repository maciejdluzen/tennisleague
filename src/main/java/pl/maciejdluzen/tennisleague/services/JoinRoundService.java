package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;

public interface JoinRoundService {

    void joinRound(SinglesPlayerSignUpDTO singlesPlayer);
}
