package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.dtos.EditSinglesPlayerDetailsDTO;
import pl.maciejdluzen.tennisleague.dtos.ReportSingleMatchResultDTO;
import pl.maciejdluzen.tennisleague.dtos.SinglesPlayerDetailsDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    List<Round> findAllByStartDateAfter(LocalDate dateNow);

    Round findFirstByStartDateAfter(LocalDate dateNow);

    User findUserByUsername(String username);

    List<Match> findAllByUserUsername();

    ReportSingleMatchResultDTO findById(Long id);

    EditSinglesPlayerDetailsDTO findSinglesPlayerByUser(Long id);

    void withdrawFromARound(EditSinglesPlayerDetailsDTO singlesPlayerDetailsDTO);

    void editUserProfile(EditSinglesPlayerDetailsDTO singlesPlayerEditDTO);

    void singlesPlayerDetails(SinglesPlayerDetailsDTO singlesPlayerDetails);

    void reportSinglesMatchResult(ReportSingleMatchResultDTO singleMatchResultDTO);

   void deleteAccount(Long id);

}
