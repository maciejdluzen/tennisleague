package pl.maciejdluzen.tennisleague.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.VerificationToken;
import pl.maciejdluzen.tennisleague.domain.repositories.VerificationTokenRepository;
import pl.maciejdluzen.tennisleague.services.VerificationTokenService;

@Service
@Transactional
@Slf4j
public class DefaultVerificationTokenService implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public DefaultVerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }
}
