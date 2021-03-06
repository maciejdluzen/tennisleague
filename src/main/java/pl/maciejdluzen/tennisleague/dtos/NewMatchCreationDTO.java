package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class NewMatchCreationDTO {


    private Long id;
    @Max(2) @Min(0)
    private Integer playerOneSets = 0;
    @Max(2) @Min(0)
    private Integer playerTwoSets = 0;

    private Long groupId;

    private Long playerOneId;

    private Long playerTwoId;
}
