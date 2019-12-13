package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import java.util.List;

@Data
public class RankingByGroupsDTO {

    private Long id;
    private String name;
    private List<String> playersFullNames;
}
