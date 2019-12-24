package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EditSinglesPlayerDetailsDTO {

    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Double ntrp;

    private Long userId;

    private Long groupId;

    private Long roundId;

    private Integer totalPoints;

    private Integer totalSetsWon;

    private Integer totalMatchesWon;

    private Integer totalMatchesLost;

    private Boolean active;

    private String notes;

}
