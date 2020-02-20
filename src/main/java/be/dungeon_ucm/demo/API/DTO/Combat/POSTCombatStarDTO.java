package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class POSTCombatStarDTO {
    private Hero[] joueurs;
    private String typeDonjon;
    private int lvlDonjon;
}
