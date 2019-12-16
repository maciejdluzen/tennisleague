package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EditMatchDTO {

    private Long id;
    @NotNull @Max(2) @Min(0)
    private Integer playerOneSets;
    @NotNull @Max(2) @Min(0)
    private Integer playerTwoSets;

    private SinglesPlayer playerOne;

    private SinglesPlayer playerTwo;

    private Long groupId;

}
