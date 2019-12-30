package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import java.util.List;

@Data
public class RankingByGroupsDTO {

    private Long id;
    private String name;
    private Round round;
    private List<String> playersDescription;
    private List<Integer> playersTotalPoints;
    private List<String> matchesDescription;
}
