package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RuleDTO {

    private Long id;
    @NotNull
    private Integer number;
    @NotBlank
    private String description;
}
