package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SinglesPlayerDetailsDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

    private Double ntrp;
}
