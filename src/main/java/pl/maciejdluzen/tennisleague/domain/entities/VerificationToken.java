package pl.maciejdluzen.tennisleague.domain.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

@Entity
@Table(name = "verification_tokens")
public class VerificationToken {

    private static final int EXPIRATION = 24;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String token;

    private LocalDateTime expiryDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    private LocalDateTime implementationOfExpiryDate() {
        return LocalDateTime.now().plusHours(EXPIRATION);
    }

    public VerificationToken(User user) {
        this.user = user;
        expiryDate = implementationOfExpiryDate();
        token = UUID.randomUUID().toString();
    }
}
