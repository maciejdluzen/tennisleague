package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.Role;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.domain.repositories.RoleRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;
import pl.maciejdluzen.tennisleague.services.RegistrationService;

@Service // nasz serwis ma byc wstrzykiwalny
@Transactional // ze pakietu spring, nie javax!
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void register(RegistrationDataDTO registrationData) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationData, User.class); // nas user bedzie miec wypelnione wszystkie pola w bazie danych co zostalo wypelnione w registration form
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);
    }
}
