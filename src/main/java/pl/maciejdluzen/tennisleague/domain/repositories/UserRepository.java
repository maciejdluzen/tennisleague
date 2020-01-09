package pl.maciejdluzen.tennisleague.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejdluzen.tennisleague.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);


    //******************************************//
    //**SQL QUERIES ONLY FOR HEROKU DEPLOYMENT**//
    //******************************************//

    @Transactional
    @Modifying
    @Query(value = "insert into users(email, password, username, active) values\n" +
            "('admin@wp.pl', '{noop}admin', 'admin', true);", nativeQuery = true)
    void createAdmin();

    @Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'admin',2);", nativeQuery = true)
    void makeAdminAdmin();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(username, email, password, active) VALUES\n" +
            "('rogerfederer', 'roger@gmail.com', '{noop}roger', true);", nativeQuery = true)
    void createUser1();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(username, email, password, active) VALUES\n" +
            "('rafaelnadal', 'rafael@gmail.com', '{noop}rafael', true);", nativeQuery = true)
    void createUser2();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(username, email, password, active) VALUES\n" +
            "('lukaszkubot', 'lukasz@gmail.com', '{noop}lukasz', true);", nativeQuery = true)
    void createUser3();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(username, email, password, active) VALUES\n" +
            "('aradwanska', 'agnieszka@gmail.com', '{noop}agnieszka', true);", nativeQuery = true)
    void createUser4();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'rogerfederer',1);", nativeQuery = true)
    void setRoleToUser1();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'rafaelnadal',1);", nativeQuery = true)
    void setRoleToUser2();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'lukaszkubot',1);", nativeQuery = true)
    void setRoleToUser3();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'aradwanska',1);", nativeQuery = true)
    void setRoleToUser4();

    //*******************************************//
    //*******************************************//
}
