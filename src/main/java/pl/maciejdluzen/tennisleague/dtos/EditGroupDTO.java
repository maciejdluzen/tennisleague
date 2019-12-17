package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import javax.validation.constraints.NotBlank;

@Data
public class EditGroupDTO {

    private Long id;
    @NotBlank
    private String name;

    private Long roundId;
}
