package be.dungeon_ucm.demo.DAL.DAO.SaveDAO;

import be.dungeon_ucm.demo.DAL.Models.Save.Salle;
import be.dungeon_ucm.demo.DAL.Models.Save.Save;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleDAO extends JpaRepository<Salle,Long> {
}
