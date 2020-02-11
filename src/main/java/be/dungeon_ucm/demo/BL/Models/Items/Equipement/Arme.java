package be.dungeon_ucm.demo.BL.Models.Items.Equipement;

import be.dungeon_ucm.demo.BL.Models.Items.ItemBasique;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Arme extends ItemBasique {

    private int degatsMin;
    private int degatsMax;
    private int niveauUtilisationMin;
    private boolean magicOuPas;
    private int tailleArme;
    private int portee;
    private NatureElement nature;

    public Arme(String nom,int durabilite, int degatsMin, int degatsMax, int niveauUtilisationMin, boolean magicOuPas,
                int tailleArme, int portee, NatureElement nature) {
        super(nom, durabilite);
        this.nature = nature;
        this.degatsMin = degatsMin;
        this.degatsMax = degatsMax;
        this.niveauUtilisationMin = niveauUtilisationMin;
        this.magicOuPas = magicOuPas;
        this.tailleArme = tailleArme;
        this.portee = portee;
    }

    public Arme() {
    }
}
