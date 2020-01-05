package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {

    List<Round> findAllByStartDateAfterAndCurrentIsFalse(LocalDate dateNow);

    List<Round> findAllByStartDateBeforeAndCurrentIsFalse(LocalDate dateNow);

    Round findFirstByStartDateAfter(LocalDate dateNow);

    Round getFirstByCurrentTrue();


    //******************************************//
    //**SQL QUERIES ONLY FOR HEROKU DEPLOYMENT**//
    //******************************************//

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rounds(name, start_date, end_date, joinby_date, midpoint_date, current_round) VALUES\n" +
    "('Runda jesienna', '2019-10-06', '2019-11-24', '2019-10-04', '2019-10-30', false);", nativeQuery = true)
    void createRound1();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rounds(name, start_date, end_date, joinby_date, midpoint_date, current_round) VALUES\n" +
            "('Runda zimowa', '2019-12-30', '2020-02-16', '2019-12-28', '2020-01-22', true);", nativeQuery = true)
    void createRound2();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rounds(name, start_date, end_date, joinby_date, midpoint_date, current_round) VALUES\n" +
            "('Runda wiosenna', '2020-03-23', '2020-05-09', '2020-03-21', '2020-04-14', false);", nativeQuery = true)
    void createRound3();

    //*******************************************//
    //*******************************************//
}
