package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByUserId(Long id);

    VerificationToken findByToken(String token);
}
