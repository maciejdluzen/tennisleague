package pl.maciejdluzen.tennisleague.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "player_one_sets")
    private Integer playerOneSets;
    @Column(nullable = false, name = "player_two_sets")
    private Integer playerTwoSets;
    @Column(name = "date_of_game")
    private LocalDate dateOfGame;

    @ManyToOne
    private SinglesPlayer playerOne;
    @ManyToOne
    private SinglesPlayer playerTwo;

    @ManyToOne
    private Group group;
}
