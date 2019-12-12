package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

import java.util.List;

public interface SinglesPlayerRepository extends JpaRepository<SinglesPlayer, Long> {

    List<SinglesPlayer> findAllByGroupName




}
