package pl.maciejdluzen.tennisleague.services.impl;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.maciejdluzen.tennisleague.domain.entities.Group;
import pl.maciejdluzen.tennisleague.domain.entities.Match;
import pl.maciejdluzen.tennisleague.domain.entities.Round;
import pl.maciejdluzen.tennisleague.domain.entities.SinglesPlayer;
import pl.maciejdluzen.tennisleague.domain.repositories.GroupRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.MatchRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.RoundRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.SinglesPlayerRepository;
import pl.maciejdluzen.tennisleague.dtos.*;
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


    /*----------------------------------------*/
    /*---------------ROUNDS-------------------*/
    /*----------------------------------------*/

    @Override
    public List<Round> findAllRounds() {
        return roundRepository.findAll();
    }

    @Override
    public void addNewRound(NewRoundCreationDTO newRound) {
        ModelMapper mapper = new ModelMapper();
        Round round = mapper.map(newRound, Round.class);
        roundRepository.save(round);
    }

    // Currently, user and round are not connected, despite having relation. Delete round do not take into account this rund functionality.

    @Override
    public void deleteRoundById(Long id) {
        List<Group> groupsByRound = groupRepository.findAllByRoundId(id);
        for(Group group : groupsByRound) {
//            group.setRound(null);
            List<SinglesPlayer> singlesPlayersByRound = singlesPlayerRepository.findAllByGroupId(group.getId());
            for(SinglesPlayer singlesPlayer : singlesPlayersByRound) {
                singlesPlayer.setGroup(null);
            }
            List<Match> matchesByGroup = matchRepository.findAllByGroupId(group.getId());
            for(Match match : matchesByGroup) {
                matchRepository.deleteById(match.getId());
            }
            groupRepository.deleteById(group.getId());
        }
        roundRepository.deleteById(id);
    }

    @Override
    public EditRoundDTO findRoundById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Round round = roundRepository.getOne(id);
        EditRoundDTO editRound = mapper.map(round, EditRoundDTO.class);
        return editRound;
    }

    @Override
    public void editRound(EditRoundDTO roundDTO) {
        ModelMapper mapper = new ModelMapper();
        Round round = mapper.map(roundDTO, Round.class);
        roundRepository.save(round);
    }

    /*----------------------------------------*/
    /*----------------GROUPS------------------*/
    /*----------------------------------------*/

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
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
    public void deleteGroupById(Long id) {

        List<Match> matchesByGroup = matchRepository.findAllByGroupId(id);
        List<SinglesPlayer> playersByGroup = singlesPlayerRepository.findAllByGroupId(id);

        for(Match match : matchesByGroup) {
            match.setGroup(null);
        }
        for(SinglesPlayer player : playersByGroup) {
            player.setGroup(null);
        }
        groupRepository.deleteById(id);
    }


    @Override
    public EditGroupDTO findGroupById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Group group = groupRepository.getOne(id);
        EditGroupDTO groupDTO = mapper.map(group, EditGroupDTO.class);
        return groupDTO;
    }

    @Override
    public void editGroup(EditGroupDTO groupDTO) {
        ModelMapper mapper = new ModelMapper();
        Group group = mapper.map(groupDTO, Group.class);
        groupRepository.save(group);
    }

    /*----------------------------------------*/
    /*-----------SINGLES PLAYERS--------------*/
    /*----------------------------------------*/


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
    public void editSinglesPlayer(EditSinglesPlayerDTO singlesPlayerDTO) {
        ModelMapper mapper = new ModelMapper();
        SinglesPlayer singlesPlayer = mapper.map(singlesPlayerDTO, SinglesPlayer.class);
        singlesPlayerRepository.save(singlesPlayer);
    }


    /*---------------------------------------*/
    /*------------- MATCHES ---------------- */
    /*---------------------------------------*/

    @Override
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public void addNewMatch(NewMatchCreationDTO newMatch) {
        ModelMapper mapper = new ModelMapper();
        Match match = mapper.map(newMatch, Match.class);
        matchRepository.save(match);
    }

    @Override
    public void deleteMatchById(Long id) {
        Match match = matchRepository.getOne(id);

        match.getPlayerOne().setTotalSetsWon(match.getPlayerOne().getTotalSetsWon()-match.getPlayerOneSets());
        match.getPlayerOne().setTotalPoints(match.getPlayerOne().getTotalPoints()-match.getPlayerOneSets());
        match.getPlayerTwo().setTotalSetsWon(match.getPlayerTwo().getTotalSetsWon()-match.getPlayerTwoSets());
        match.getPlayerTwo().setTotalPoints(match.getPlayerTwo().getTotalPoints()-match.getPlayerTwoSets());
        if(match.getPlayerOneSets() > match.getPlayerTwoSets()) {
            match.getPlayerOne().setTotalMatchesWon(match.getPlayerOne().getTotalMatchesWon()-1);
            match.getPlayerTwo().setTotalMatchesLost(match.getPlayerTwo().getTotalMatchesLost()-1);
        }
        if(match.getPlayerTwoSets() > match.getPlayerTwoSets()) {
            match.getPlayerTwo().setTotalMatchesWon(match.getPlayerTwo().getTotalMatchesWon()-1);
            match.getPlayerOne().setTotalMatchesLost(match.getPlayerOne().getTotalMatchesLost()-1);
        }

        matchRepository.deleteById(id);
    }

    @Override
    public EditMatchDTO findMatchById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Match match = matchRepository.getOne(id);

        match.getPlayerOne().setTotalSetsWon(match.getPlayerOne().getTotalSetsWon()-match.getPlayerOneSets());
        match.getPlayerOne().setTotalPoints(match.getPlayerOne().getTotalPoints()-match.getPlayerOneSets());
        match.getPlayerTwo().setTotalSetsWon(match.getPlayerTwo().getTotalSetsWon()-match.getPlayerTwoSets());
        match.getPlayerTwo().setTotalPoints(match.getPlayerTwo().getTotalPoints()-match.getPlayerTwoSets());

        if(match.getPlayerOneSets() > match.getPlayerTwoSets()) {
            match.getPlayerOne().setTotalMatchesWon(match.getPlayerOne().getTotalMatchesWon()-1);
            match.getPlayerTwo().setTotalMatchesLost(match.getPlayerTwo().getTotalMatchesLost()-1);
        }
        if(match.getPlayerTwoSets() > match.getPlayerOneSets()) {
            match.getPlayerTwo().setTotalMatchesWon(match.getPlayerTwo().getTotalMatchesWon()-1);
            match.getPlayerOne().setTotalMatchesLost(match.getPlayerOne().getTotalMatchesLost()-1);
        }

        EditMatchDTO matchDTO = mapper.map(match, EditMatchDTO.class);
        return matchDTO;
    }

    @Override
    public void editMatch(EditMatchDTO matchDTO) {
        ModelMapper mapper = new ModelMapper();
        Match match = mapper.map(matchDTO, Match.class);

        match.setPlayerOneSets(matchDTO.getPlayerOneSets());

        match.getPlayerOne().setTotalSetsWon(match.getPlayerOne().getTotalSetsWon()+matchDTO.getPlayerOneSets());
        match.getPlayerOne().setTotalPoints(match.getPlayerOne().getTotalPoints()+matchDTO.getPlayerOneSets());

        match.setPlayerTwoSets(matchDTO.getPlayerTwoSets());

        match.getPlayerTwo().setTotalSetsWon(match.getPlayerTwo().getTotalSetsWon()+matchDTO.getPlayerTwoSets());
        match.getPlayerTwo().setTotalPoints(match.getPlayerTwo().getTotalPoints()+matchDTO.getPlayerTwoSets());

        if(matchDTO.getPlayerOneSets() > matchDTO.getPlayerTwoSets()) {
            match.getPlayerOne().setTotalMatchesWon(match.getPlayerOne().getTotalMatchesWon()+1);
            match.getPlayerTwo().setTotalMatchesLost(match.getPlayerTwo().getTotalMatchesLost()+1);
        }
        if(matchDTO.getPlayerTwoSets() > matchDTO.getPlayerOneSets()) {
            match.getPlayerTwo().setTotalMatchesWon(match.getPlayerTwo().getTotalMatchesWon()+1);
            match.getPlayerOne().setTotalMatchesLost(match.getPlayerOne().getTotalMatchesLost()+1);
        }
        matchRepository.save(match);
    }
}
