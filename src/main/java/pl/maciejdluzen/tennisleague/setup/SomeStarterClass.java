package pl.maciejdluzen.tennisleague.setup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Role;
import pl.maciejdluzen.tennisleague.domain.repositories.RoleRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;

@Component @Profile("heroku")
public class SomeStarterClass implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public SomeStarterClass(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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

        userRepository.createAdmin();
        userRepository.makeAdminAdmin();
    }
}