package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;
import pl.maciejdluzen.tennisleague.services.JoinRoundService;

@Service
@Transactional
public class DefaultJoinRoundService implements JoinRoundService {

    private final SinglesPlayerRepository singlesPlayerRepository;
    private final UserRepository userRepository;

    public DefaultJoinRoundService(SinglesPlayerRepository singlesPlayerRepository, UserRepository userRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.userRepository = userRepository;
    }

    // need to assign this singlesPlayer to user !!! ids shall be the same !!!
    @Override
    public void joinRound(SinglesPlayerSignUpDTO singlesPlayerData) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByUsername(username);
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = mapper.map(singlesPlayerData, SinglesPlayer.class);
        singlesPlayer.setUser(user);
        singlesPlayerRepository.save(singlesPlayer);
    }
}
