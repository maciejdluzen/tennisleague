package pl.maciejdluzen.tennisleague.services;

public interface ValidationService {

    boolean isUniqueEmail(String email);

    boolean isUniqueUsername(String username);

}
