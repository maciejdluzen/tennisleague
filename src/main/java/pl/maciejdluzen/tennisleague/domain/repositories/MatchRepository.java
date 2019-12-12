package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.User;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.playerOne.user.username = ?1 OR m.playerTwo.user.username = ?1")
    List<Match> findAllByUsername(String username);

}
