package pl.maciejdluzen.tennisleague.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.GroupRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.MatchRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.EditSinglesPlayerDTO;
import pl.maciejdluzen.tennisleague.dtos.NewGroupCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewMatchCreationDTO;
import pl.maciejdluzen.tennisleague.dtos.NewRoundCreationDTO;
import pl.maciejdluzen.tennisleague.services.AdminService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional @Slf4j
public class DefaultAdminService implements AdminService {

    private final RoundRepository roundRepository;
    private final GroupRepository groupRepository;
    private final SinglesPlayerRepository singlesPlayerRepository;
    private final MatchRepository matchRepository;
    //ten model mapper został wstrzyknięty opcjonalnie (ustawiona strategia STRICT zamiast STANDART)

    public DefaultAdminService(RoundRepository roundRepository, GroupRepository groupRepository, SinglesPlayerRepository singlesPlayerRepository, MatchRepository matchRepository) {
        this.roundRepository = roundRepository;
        this.groupRepository = groupRepository;
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void addNewRound(NewRoundCreationDTO newRound) {
        ModelMapper mapper = new ModelMapper();
        Round round = mapper.map(newRound, Round.class);
        roundRepository.save(round);
    }

    @Override
    public void addNewGroup(NewGroupCreationDTO newGroup) {
        ModelMapper mapper = new ModelMapper();
        Group group = mapper.map(newGroup, Group.class);
        // ModelMapper mapuje pole roundId również na pole id w encji (WTF?!) - dlatego zostało dodane setId własnoręcznie
        group.setId(null);
        log.info("Group to save: {}", group);
        groupRepository.save(group);
    }

    @Override
    public List<Round> findAllRounds() {
        return roundRepository.findAll();
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<SinglesPlayer> findAllSinglesPlayers() {
        return singlesPlayerRepository.findAll();
    }

    @Override
    public EditSinglesPlayerDTO findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<SinglesPlayer> result = singlesPlayerRepository.findById(id);
        SinglesPlayer singlesPlayer = result.get();
        EditSinglesPlayerDTO singlesPlayerDTO = mapper.map(singlesPlayer, EditSinglesPlayerDTO.class);
        return singlesPlayerDTO;
    }

    @Override
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public void editSinglesPlayer(EditSinglesPlayerDTO singlesPlayerDTO) {
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = mapper.map(singlesPlayerDTO, SinglesPlayer.class);
        singlesPlayerRepository.save(singlesPlayer);
    }

    @Override
    public void addNewMatch(NewMatchCreationDTO newMatch) {
        ModelMapper mapper = new ModelMapper();
        Match match = mapper.map(newMatch, Match.class);
        matchRepository.save(match);
    }

    @Override
    public void deleteMatchById(Long id) {
        matchRepository.deleteById(id);
    }
}
