package pl.maciejdluzen.tennisleague.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class NewMatchCreationDTO {


    private Long id;

    private Integer playerOneSets;

    private Integer playerTwoSets;

    








}
