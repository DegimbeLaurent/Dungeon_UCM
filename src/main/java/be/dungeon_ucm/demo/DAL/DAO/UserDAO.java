package be.dungeon_ucm.demo.DAL.DAO;

import be.dungeon_ucm.demo.DAL.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;


public interface UserDAO extends JpaRepository<User,Long> {
    Optional<User> getByPseudo(String pseudo);

    @Override
    <S extends User> S save(S s);
}
