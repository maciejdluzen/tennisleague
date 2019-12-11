package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import java.time.LocalDate;

@Service
@Transactional
public class DefaultAdminService implements AdminService {

    private final RoundRepository roundRepository;

    public DefaultAdminService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    @Override
    public void addNewRound(NewRoundCreationDTO newRound) {
        ModelMapper mapper = new ModelMapper();
        Round round = mapper.map(newRound, Round.class);
        roundRepository.save(round);
    }
}
