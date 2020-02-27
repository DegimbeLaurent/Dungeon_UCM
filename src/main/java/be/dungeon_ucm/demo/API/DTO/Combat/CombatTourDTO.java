package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.DAL.Models.Save.Heroes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class CombatTourDTO {

    private Monstre monstreattaquant;
    private Hero heroesattaquant;
    private Monstre[] monstreSetdefenseur;
    private Hero[] heroesSetdefenseur;
    private int choix;
    private int cap;
    private Consommable consommable;

    public CombatTourDTO() {
    }
}
