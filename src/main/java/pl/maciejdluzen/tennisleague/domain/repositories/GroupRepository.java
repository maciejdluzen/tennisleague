package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

import javax.persistence.Entity;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "singlePlayers")
        List<Group> findAllWithSinglesPlayersAndMatchesByOrderBySinglePlayersTotalPointsDesc();

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "matches")
        List<Group> findAllWithMatchesBy();

        List<Group> findAllByRoundId(Long id);

//        List<Group> findAllWithSinglesPlayersBy();
}
