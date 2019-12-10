package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;
import pl.maciejdluzen.tennisleague.services.JoinRoundService;

@Service
@Transactional
public class DefaultJoinRoundService implements JoinRoundService {

    private final SinglesPlayerRepository singlesPlayerRepository;

    public DefaultJoinRoundService(SinglesPlayerRepository singlesPlayerRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
    }

    // need to assign this singlesPlayer to user !!! ids shall be the same !!!
    @Override
    public void joinRound(SinglesPlayerSignUpDTO singlesPlayerData) {
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = mapper.map(singlesPlayerData, SinglesPlayer.class);
        singlesPlayerRepository.save(singlesPlayer);
    }
}
