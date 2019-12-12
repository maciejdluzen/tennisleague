package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ReportSingleMatchResultDTO {

    private Long id;
    @Max(2) @Min(0)
    private Integer playerOneSets = 0;
    @Max(2) @Min(0)
    private Integer playerTwoSets = 0;

    private String playerOneLastName;
    private String playerTwoLastName;

}
