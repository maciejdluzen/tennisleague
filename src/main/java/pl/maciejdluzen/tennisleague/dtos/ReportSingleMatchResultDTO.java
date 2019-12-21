package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReportSingleMatchResultDTO {

    private Long id;
    @Max(2) @Min(0)
    private Integer playerOneSets = 0;
    @Max(2) @Min(0)
    private Integer playerTwoSets = 0;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateOfGame;

    private String playerOneLastName;
    private String playerTwoLastName;

}
