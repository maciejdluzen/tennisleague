package pl.maciejdluzen.tennisleague.domain.entities;

import java.time.LocalDate;

public class Round {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    // TODO Prepare Round Entity
    // OneToMany relationship with group (Many groups belong to one round)
    // ManyToMany relationship with singles players (Many players belong to many groups)


}
