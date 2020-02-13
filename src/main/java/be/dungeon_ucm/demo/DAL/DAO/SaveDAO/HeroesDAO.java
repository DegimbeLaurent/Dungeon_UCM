package be.dungeon_ucm.demo.DAL.DAO.SaveDAO;

import be.dungeon_ucm.demo.DAL.Models.Save.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroesDAO extends JpaRepository<Heroes,Long> {
}
