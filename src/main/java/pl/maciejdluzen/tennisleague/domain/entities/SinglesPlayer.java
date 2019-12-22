package pl.maciejdluzen.tennisleague.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "singles_players")
public class SinglesPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private Double ntrp;
    @Column(name = "total_points")
    private Integer totalPoints = 0;
    @Column(name = "sets_won")
    private Integer totalSetsWon = 0;
    @Column(name = "matches_won")
    private Integer totalMatchesWon = 0;
    @Column(name = "matches_lost")
    private Integer totalMatchesLost = 0;
    @Column(nullable = false)
    private Boolean active = Boolean.TRUE;
    @Column
    private String notes = " ";

    @OneToOne
    private User user;

    @ManyToOne
    private Group group;

}
