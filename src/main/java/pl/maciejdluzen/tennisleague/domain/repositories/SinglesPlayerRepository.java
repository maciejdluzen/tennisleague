package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

import java.util.List;

public interface SinglesPlayerRepository extends JpaRepository<SinglesPlayer, Long> {

    List<SinglesPlayer> findAllByGroupIdOrderByTotalPointsDescTotalMatchesWonDesc(Long id);

    List<SinglesPlayer> findAllByGroupId(Long id);

    SinglesPlayer findByUserId(Long id);


    //******************************************//
    //**SQL QUERIES ONLY FOR HEROKU DEPLOYMENT**//
    //******************************************//

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO singles_players(active, first_name, last_name, phone_number, ntrp, group_id, round_id, user_id, matches_won, matches_lost, sets_won, total_points) VALUES\n" +
    "(true, 'Roger', 'Federer', '734265187', 5.0, 1, 2, 2, 0, 0, 0, 0);", nativeQuery = true)
    void createPlayer1();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO singles_players(active, first_name, last_name, phone_number, ntrp, group_id, round_id, user_id, matches_won, matches_lost, sets_won, total_points) VALUES\n" +
            "(true, 'Rafael', 'Nadal', '650657877', 4.5, 1, 2, 3, 0, 0, 0, 0);", nativeQuery = true)
    void createPlayer2();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO singles_players(active, first_name, last_name, phone_number, ntrp, group_id, round_id, user_id, matches_won, matches_lost, sets_won, total_points) VALUES\n" +
            "(true, 'Lukasz', 'Kubot', '540700460', 6.5, 2, 2, 4, 0, 0, 0, 0);", nativeQuery = true)
    void createPlayer3();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO singles_players(active, first_name, last_name, phone_number, ntrp, group_id, round_id, user_id, matches_won, matches_lost, sets_won, total_points) VALUES\n" +
            "(true, 'Agnieszka', 'Radwanska', '670556480', 5.5, 2, 2, 5, 0, 0, 0, 0);", nativeQuery = true)
    void createPlayer4();

    //*******************************************//
    //*******************************************//
}
