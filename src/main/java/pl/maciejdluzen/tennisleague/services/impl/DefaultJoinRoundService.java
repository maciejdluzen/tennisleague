package pl.maciejdluzen.tennisleague.services.impl;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerDetailsDTO;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerSignUpDTO;
import pl.maciejdluzen.tennisleague.services.JoinRoundService;

import java.util.List;

@Service
@Transactional
public class DefaultJoinRoundService implements JoinRoundService {

    private final SinglesPlayerRepository singlesPlayerRepository;
    private final UserRepository userRepository;
    private final RoundRepository roundRepository;

    public DefaultJoinRoundService(SinglesPlayerRepository singlesPlayerRepository, UserRepository userRepository, RoundRepository roundRepository) {
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.userRepository = userRepository;
        this.roundRepository = roundRepository;
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

    @Override
    public List<Round> findAllRounds() {
        return roundRepository.findAll();
    }

    @Override
    public SinglesPlayerSignUpDTO findSinglesPlayerByUser(Long id) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        User user = userRepository.getByUsername(username);
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = singlesPlayerRepository.findByUserId(id);
        SinglesPlayerSignUpDTO singlesPlayerSignUp = mapper.map(singlesPlayer, SinglesPlayerSignUpDTO.class);
        return singlesPlayerSignUp;
    }

    @Override
    public void singlesPlayerRoundSignUp(SinglesPlayerSignUpDTO singlesPlayerSignUp) {
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = mapper.map(singlesPlayerSignUp, SinglesPlayer.class);
        singlesPlayerRepository.save(singlesPlayer);
    }
}
