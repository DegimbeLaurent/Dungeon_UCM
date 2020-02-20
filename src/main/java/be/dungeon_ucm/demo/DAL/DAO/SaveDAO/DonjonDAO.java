package be.dungeon_ucm.demo.DAL.DAO.SaveDAO;

import be.dungeon_ucm.demo.DAL.Models.Save.Donjon;
import be.dungeon_ucm.demo.DAL.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonjonDAO extends JpaRepository<Donjon,Long> {

}
