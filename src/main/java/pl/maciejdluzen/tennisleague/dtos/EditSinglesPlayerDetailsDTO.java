package pl.maciejdluzen.tennisleague.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EditSinglesPlayerDetailsDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Double ntrp;

}
