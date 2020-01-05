package pl.maciejdluzen.tennisleague.setup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Role;
import pl.maciejdluzen.tennisleague.domain.repositories.*;

@Component @Profile("heroku")
public class SomeStarterClass implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final RoundRepository roundRepository;
    private final GroupRepository groupRepository;
    private final SinglesPlayerRepository singlesPlayerRepository;
    private final MatchRepository matchRepository;

    public SomeStarterClass(RoleRepository roleRepository, UserRepository userRepository, RoundRepository roundRepository, GroupRepository groupRepository, SinglesPlayerRepository singlesPlayerRepository, MatchRepository matchRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.roundRepository = roundRepository;
        this.groupRepository = groupRepository;
        this.singlesPlayerRepository = singlesPlayerRepository;
        this.matchRepository = matchRepository;
    }

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Role userRole = new Role();
        userRole.setId(1L);
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);
        Role userRole2 = new Role();
        userRole2.setId(2L);
        userRole2.setName("ROLE_ADMIN");
        roleRepository.save(userRole2);

        // Create admin and 4 users

        userRepository.createAdmin();
        userRepository.makeAdminAdmin();

        userRepository.createUser1();
        userRepository.setRoleToUser1();

        userRepository.createUser2();
        userRepository.setRoleToUser2();

        userRepository.createUser3();
        userRepository.setRoleToUser3();

        userRepository.createUser4();
        userRepository.setRoleToUser4();

        // Create 3 rounds (previous, current and future)

        roundRepository.createRound1();
        roundRepository.createRound2();
        roundRepository.createRound3();

        // Create 2 groups in the current round

        groupRepository.createGroup1();
        groupRepository.createGroup2();

        // Create 4 players, assign to the round and group

        singlesPlayerRepository.createPlayer1();
        singlesPlayerRepository.createPlayer2();
        singlesPlayerRepository.createPlayer3();
        singlesPlayerRepository.createPlayer4();

        // Create match between players in one group

        matchRepository.createMatch1();
    }
}
