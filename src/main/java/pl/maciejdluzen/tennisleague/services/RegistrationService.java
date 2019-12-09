package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;

public interface RegistrationService {

    void register(RegistrationDataDTO registrationData);
}
