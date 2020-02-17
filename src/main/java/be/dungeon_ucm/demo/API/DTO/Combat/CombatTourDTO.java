package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CombatTourDTO {

    private Personnage[] personnages;
    private int choix;
    private int cap;
    private Consommable consommable;

    public CombatTourDTO(Personnage[] personnages, int choix, int cap) {
        this.personnages = personnages;
        this.choix = choix;
        this.cap = cap;
    }

    public CombatTourDTO(Personnage[] personnages, int choix, Consommable consommable) {
        this.personnages = personnages;
        this.choix = choix;
        this.consommable = consommable;
    }
}
