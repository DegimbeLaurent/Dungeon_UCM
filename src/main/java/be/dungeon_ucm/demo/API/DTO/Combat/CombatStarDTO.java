package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class CombatStarDTO {

    private Personnage[] joueurs;
    private Personnage[] Monstre;
    private NatureElement TypeDonjon;
    private int lvlDonjon;
    private Long[] ordre;

    public CombatStarDTO(Personnage[] joueurs, Personnage[] monstre, NatureElement typeDonjon, int lvlDonjon) {
        this.joueurs = joueurs;
        Monstre = monstre;
        TypeDonjon = typeDonjon;
        this.lvlDonjon = lvlDonjon;
    }

    public CombatStarDTO(Personnage[] joueurs, NatureElement typeDonjon, int lvlDonjon) {
        this.joueurs = joueurs;
        TypeDonjon = typeDonjon;
        this.lvlDonjon = lvlDonjon;
    }
}
