package be.dungeon_ucm.demo.DAL.DAO.SaveDAO;

import be.dungeon_ucm.demo.DAL.Models.Save.Save;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveDAO extends JpaRepository<Save,Long> {
}
