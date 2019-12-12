package pl.maciejdluzen.tennisleague.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.MatchRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.dtos.ReportSingleMatchResultDTO;
import pl.maciejdluzen.tennisleague.services.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional @Slf4j
public class DefaultUserService implements UserService {

    private final RoundRepository roundRepository;
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;
    private final SinglesPlayerRepository singlesPlayerRepository;

    public DefaultUserService(RoundRepository roundRepository, UserRepository userRepository, MatchRepository matchRepository, SinglesPlayerRepository singlesPlayerRepository) {
        this.roundRepository = roundRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
        this.singlesPlayerRepository = singlesPlayerRepository;
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

    @Override
    public ReportSingleMatchResultDTO findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Match match = matchRepository.getOne(id);
        ReportSingleMatchResultDTO matchResultDTO = mapper.map(match, ReportSingleMatchResultDTO.class);
        log.info("Returning match info: {}", matchResultDTO);
        return matchResultDTO;
    }

    @Override
    public void reportSinglesMatchResult(ReportSingleMatchResultDTO singleMatchResultDTO) {

        Match match = matchRepository.getOne(singleMatchResultDTO.getId());
        match.setPlayerOneSets(singleMatchResultDTO.getPlayerOneSets());

        match.getPlayerOne().setTotalSetsWon(match.getPlayerOne().getTotalSetsWon() + singleMatchResultDTO.getPlayerOneSets()); // nowe

        log.info("Player one {} sets: {}", singleMatchResultDTO.getPlayerOneLastName(), singleMatchResultDTO.getPlayerOneSets());
        log.info("Player two {} sets: {}", singleMatchResultDTO.getPlayerTwoLastName(), singleMatchResultDTO.getPlayerTwoSets());

        match.setPlayerTwoSets(singleMatchResultDTO.getPlayerTwoSets());

        match.getPlayerTwo().setTotalSetsWon(match.getPlayerTwo().getTotalSetsWon() + singleMatchResultDTO.getPlayerTwoSets()); // nowe
        matchRepository.save(match);
    }
}
