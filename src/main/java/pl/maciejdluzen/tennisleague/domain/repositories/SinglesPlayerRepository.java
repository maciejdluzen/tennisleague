package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

public interface SinglesPlayerRepository extends JpaRepository<SinglesPlayer, Long> {
}
