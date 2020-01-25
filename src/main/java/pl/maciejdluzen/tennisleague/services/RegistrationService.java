package pl.maciejdluzen.tennisleague.services;

import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;

import javax.validation.Valid;

public interface RegistrationService {

    void register(@Valid RegistrationDataDTO registrationData);










}
