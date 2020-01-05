package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.entities.User;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.playerOne.user.username = ?1 OR m.playerTwo.user.username = ?1")
    List<Match> findAllByUsername(String username);

    List<Match> findAllByGroupId(Long id);

    @Query("SELECT m FROM Match m WHERE m.playerOne = ?1 OR m.playerTwo = ?1")
    List<Match> findAllBySinglesPlayer(SinglesPlayer singlesPlayer);

    //******************************************//
    //**SQL QUERIES ONLY FOR HEROKU DEPLOYMENT**//
    //******************************************//

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO matches(player_one_sets, player_two_sets, group_id, player_one_id, player_two_id) VALUES\n" +
    "(0, 0, 1, 1, 2);", nativeQuery = true)
    void createMatch1();

    //*******************************************//
    //*******************************************//

}
