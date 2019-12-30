package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class EditRoundDTO {

    private Long id;
    @NotBlank
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate midpointDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate joinByDate;

}
