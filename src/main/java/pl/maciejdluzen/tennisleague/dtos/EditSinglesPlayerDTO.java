package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class EditSinglesPlayerDTO {


    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

    private Double ntrp;

    private Integer totalPoints;

    private Integer totalSetsWon;

    private Integer totalMatchesWon;

    private Integer totalMatchesLost;

    private Long groupId;

    private Long userId;

    private Long roundId;

    private String notes;

}
