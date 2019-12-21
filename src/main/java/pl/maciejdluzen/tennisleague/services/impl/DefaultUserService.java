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
        match.setDateOfGame(singleMatchResultDTO.getDateOfGame());
        match.setPlayerOneSets(singleMatchResultDTO.getPlayerOneSets());

        match.getPlayerOne().setTotalSetsWon(match.getPlayerOne().getTotalSetsWon() + singleMatchResultDTO.getPlayerOneSets()); // add won sets to total sets count
        match.getPlayerOne().setTotalPoints(match.getPlayerOne().getTotalPoints() + singleMatchResultDTO.getPlayerOneSets()); // add points


        log.info("Player one {} sets: {}", singleMatchResultDTO.getPlayerOneLastName(), singleMatchResultDTO.getPlayerOneSets());
        log.info("Player two {} sets: {}", singleMatchResultDTO.getPlayerTwoLastName(), singleMatchResultDTO.getPlayerTwoSets());

        match.setPlayerTwoSets(singleMatchResultDTO.getPlayerTwoSets());

        match.getPlayerTwo().setTotalSetsWon(match.getPlayerTwo().getTotalSetsWon() + singleMatchResultDTO.getPlayerTwoSets()); // add won sets to total sets count
        match.getPlayerTwo().setTotalPoints(match.getPlayerTwo().getTotalPoints() + singleMatchResultDTO.getPlayerTwoSets()); // add points

        // adding won and lost matches to the total count of the players

        if(singleMatchResultDTO.getPlayerOneSets() > singleMatchResultDTO.getPlayerTwoSets()) {
            match.getPlayerOne().setTotalMatchesWon(match.getPlayerOne().getTotalMatchesWon()+1);
            match.getPlayerTwo().setTotalMatchesLost(match.getPlayerTwo().getTotalMatchesLost()+1);
        }
        if(singleMatchResultDTO.getPlayerTwoSets() > singleMatchResultDTO.getPlayerOneSets()) {
            match.getPlayerTwo().setTotalMatchesWon(match.getPlayerTwo().getTotalMatchesWon()+1);
            match.getPlayerOne().setTotalMatchesLost(match.getPlayerOne().getTotalMatchesLost()+1);
        }
        matchRepository.save(match);
    }
}
