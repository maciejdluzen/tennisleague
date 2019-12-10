package pl.maciejdluzen.tennisleague.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString(exclude = "singlesPlayers2")
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "winner_sets")
    private Integer winnerSets;
    @Column(nullable = false, name = "loser_sets")
    private Integer loserSets;

    @ManyToMany
    private List<SinglesPlayer> singlesPlayers2 = new ArrayList<>();

    @ManyToMany(mappedBy = "matches2")
    private List<Group> groups2 = new ArrayList<>();
}
