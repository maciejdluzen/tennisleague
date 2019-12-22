package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.domain.entities.Round;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SinglesPlayerSignUpDTO {

    // This DTO is used when a user whats to sign up for a round (all info comes from the form)

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

    private Double ntrp;

    private Round round;

//    @NotBlank
//    private List<Round> rounds; // round which users whants to play in

//    private Integer totalPoints;
//    private Integer totalSetsWon;
//    private Integer totalSetsLost;
}
