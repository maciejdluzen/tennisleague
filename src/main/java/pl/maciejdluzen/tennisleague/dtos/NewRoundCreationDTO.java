package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class NewRoundCreationDTO {

    @NotBlank
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank
    private LocalDateTime startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank
    private LocalDateTime endDate;

}
