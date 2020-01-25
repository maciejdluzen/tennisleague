package pl.maciejdluzen.tennisleague.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import pl.maciejdluzen.tennisleague.domain.entities.Role;
import pl.maciejdluzen.tennisleague.domain.entities.User;
import pl.maciejdluzen.tennisleague.domain.entities.VerificationToken;
import pl.maciejdluzen.tennisleague.domain.repositories.RoleRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.UserRepository;
import pl.maciejdluzen.tennisleague.domain.repositories.VerificationTokenRepository;
import pl.maciejdluzen.tennisleague.dtos.RegistrationDataDTO;
import pl.maciejdluzen.tennisleague.services.EmailService;
import pl.maciejdluzen.tennisleague.services.RegistrationService;
import pl.maciejdluzen.tennisleague.validation.groups.BusinessLogic;

import javax.validation.Valid;

@Service // nasz serwis ma byc wstrzykiwalny
@Transactional // ze pakietu spring, nie javax!
@Validated
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EmailService emailService;
    private final VerificationTokenRepository verificationTokenRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, EmailService emailService, VerificationTokenRepository verificationTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override @Validated({BusinessLogic.class})
    public void register(@Valid RegistrationDataDTO registrationData) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationData, User.class); // nas user bedzie miec wypelnione wszystkie pola w bazie danych co zostalo wypelnione w registration form
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        VerificationToken verificationToken = new VerificationToken(user);
        emailService.sendSimpleMessage(user.getEmail(), "Wrocławska liga tenisowa: Dokończ swoją rejestrację",
                "Aby aktywować konto, kliknij na link" +
                        "http://localhost:8080/register/confirmation?token="+verificationToken.getToken());
        userRepository.save(user);
        verificationTokenRepository.save(verificationToken);
    }
}
