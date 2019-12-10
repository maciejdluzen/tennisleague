package pl.maciejdluzen.tennisleague.domain.entities;

public class Group {

    private Long id;
    private String name;

    // TODO Prepare Group Entity
    // OneToMany relationship with SinglesPlayer(Many players belong to one group)
    // OneToMany relationship with Matches (Many matches in one group)
    // Many to Many relatiohship with SinglePlayer(Many players may play in amny rounds)
}
