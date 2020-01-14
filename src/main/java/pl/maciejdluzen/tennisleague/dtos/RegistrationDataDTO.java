package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import pl.maciejdluzen.tennisleague.validation.constraints.SamePasswords;
import pl.maciejdluzen.tennisleague.validation.constraints.UniqueEmail;
import pl.maciejdluzen.tennisleague.validation.constraints.UniqueUsername;
import pl.maciejdluzen.tennisleague.validation.groups.BusinessLogic;

import javax.validation.constraints.*;
import java.util.concurrent.Flow;


@Data @SamePasswords
public class RegistrationDataDTO {

    @NotBlank @Size(min = 3, max = 12) @UniqueUsername(groups = BusinessLogic.class)
    private String username;
    @NotBlank @Email @UniqueEmail(groups = BusinessLogic.class)
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;
}
