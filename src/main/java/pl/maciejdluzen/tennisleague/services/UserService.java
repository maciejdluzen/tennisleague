package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.dtos.ReportSingleMatchResultDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    List<Round> findAllByStartDateAfter(LocalDate dateNow);

    Round findFirstByStartDateAfter(LocalDate dateNow);

    List<Match> findAllByUserUsername();

    ReportSingleMatchResultDTO findById(Long id);

    void reportSinglesMatchResult(ReportSingleMatchResultDTO singleMatchResultDTO);
}
