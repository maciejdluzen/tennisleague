package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NewGroupCreationDTO {

    @NotBlank
    private String name;
    @NotNull
    private Long roundId;
}
