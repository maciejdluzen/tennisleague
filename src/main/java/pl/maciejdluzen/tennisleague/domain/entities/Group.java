package pl.maciejdluzen.tennisleague.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(exclude = {"singlePlayers", "matches"})

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "group") // swap mapping to singlePlayers3 in SinglePlayer entity
    private List<SinglesPlayer> singlePlayers = new ArrayList<>();

    @ManyToOne
    private Round round;

    @OneToMany(mappedBy = "group")
    private List<Match> matches = new ArrayList<>();
}
