package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.domain.entities.VerificationToken;

public interface VerificationTokenService {

    VerificationToken findByToken(String token);
}
