package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

import javax.persistence.Entity;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "singlePlayers")
        List<Group> findAllWithSinglesPlayersAndMatchesByOrderBySinglePlayersTotalPointsDesc();

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "singlePlayers")
        Group findWithSinglesPlayersAndMatchesByIdOrderBySinglePlayersTotalPointsDesc(Long id);

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "matches")
        List<Group> findAllWithMatchesBy();

        List<Group> findAllByRoundId(Long id);


        //******************************************//
        //**SQL QUERIES ONLY FOR HEROKU DEPLOYMENT**//
        //******************************************//

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO groups(name, round_id) VALUES\n" +
        "('Grupa 1', 2);", nativeQuery = true)
        void createGroup1();

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO groups(name, round_id) VALUES\n" +
                "('Grupa 2', 2);", nativeQuery = true)
        void createGroup2();

        //*******************************************//
        //*******************************************//

}
