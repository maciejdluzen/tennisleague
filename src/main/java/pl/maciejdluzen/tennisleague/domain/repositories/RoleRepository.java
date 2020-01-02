package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciejdluzen.tennisleague.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);
}
