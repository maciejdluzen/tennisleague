package pl.maciejdluzen.tennisleague.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.services.ValidationService;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultValidationService implements ValidationService {

    private final UserRepository userRepository;

    @Override
    public boolean isUniqueEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    @Override
    public boolean isUniqueUsername(String username) {
        return !userRepository.existsByUsername(username);
    }
}
