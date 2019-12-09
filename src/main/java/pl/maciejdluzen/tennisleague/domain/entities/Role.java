package pl.maciejdluzen.tennisleague.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
}
