package pl.maciejdluzen.tennisleague.services;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
