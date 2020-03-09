package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CombatStarDTO {

    private Monstre monstreattaquant;
    private Hero heroesattaquant;

    private Hero[] joueurs;
    private Monstre[] monstre;

    private String typeDonjon;
    private int lvlDonjon;
    private Long[] ordre;

    private int choix;
    private int cap;
    private Consommable consommable;
    private int[] cible;

    public CombatStarDTO(Hero[] joueurs, String typeDonjon, int lvlDonjon) {
        this.joueurs = joueurs;
        this.typeDonjon = typeDonjon;
        this.lvlDonjon = lvlDonjon;
    }

    public CombatStarDTO() {
    }
}
