package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.Round;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    List<Round> findAllByStartDateAfter(LocalDate dateNow);

    Round findFirstByStartDateAfter(LocalDate dateNow);
}
