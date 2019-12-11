package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {

    List<Round> findAllByStartDateAfter(LocalDate dateNow);

    Round findFirstByStartDateAfter(LocalDate dateNow);
}
