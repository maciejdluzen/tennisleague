package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.concurrent.Flow;


@Data
public class RegistrationDataDTO {

    @NotBlank @Size(min = 3, max = 12)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;

    // Tutaj umiescimy rowniez listy z polami wyboru

    // Dla klasy Book
//    private Publisher publisher;
//
//    private Long publisherId; //nastapi automatyczna konwersja przez modelmappera

}
