package pl.maciejdluzen.tennisleague.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(exclude = {"singlesPlayers", "groups"})

@Entity
@Table(name = "rounds")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "midpoint_date", nullable = false)
    private LocalDate midpointDate;
    @Column(name = "joinby_date", nullable = false)
    private LocalDate joinByDate;
    @Column(name = "current_round", nullable = false)
    private Boolean current = Boolean.FALSE;

    @OneToMany(mappedBy = "round")
    private List<SinglesPlayer> singlesPlayers = new ArrayList<>();

    @OneToMany(mappedBy = "round")
    private List<Group> groups = new ArrayList<>();
}
