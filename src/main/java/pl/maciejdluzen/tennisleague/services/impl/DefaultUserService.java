package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.domain.repositories.MatchRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.services.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private final RoundRepository roundRepository;
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    public DefaultUserService(RoundRepository roundRepository, UserRepository userRepository, MatchRepository matchRepository) {
        this.roundRepository = roundRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Round> findAllByStartDateAfter(LocalDate dateNow) {
        return roundRepository.findAllByStartDateAfter(dateNow);
    }

    @Override
    public Round findFirstByStartDateAfter(LocalDate dateNow) {
        return roundRepository.findFirstByStartDateAfter(dateNow);
    }

    @Override
    public List<Match> findAllByUserUsername() {
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        return matchRepository.findAllByUsername(username);
    }
}
