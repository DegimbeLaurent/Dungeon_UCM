package be.dungeon_ucm.demo.BL.Models.Items.Equipement;

import be.dungeon_ucm.demo.BL.Models.Items.ItemBasique;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


public class Arme extends ItemBasique {

    private int degatsMin;
    private int degatsMax;
    private int niveauUtilisationMin;
    private boolean magicOuPas;
    private int tailleArme;
    private NatureElement nature;

    public Arme(String nom,int durabilite, int degatsMin, int degatsMax, int niveauUtilisationMin, boolean magicOuPas,
                int tailleArme, NatureElement nature) {
        super(nom, durabilite);
        this.nature = nature;
        this.degatsMin = degatsMin;
        this.degatsMax = degatsMax;
        this.niveauUtilisationMin = niveauUtilisationMin;
        this.magicOuPas = magicOuPas;
        this.tailleArme = tailleArme;
    }

    public Arme() {
    }

    public int getDegatsMin() {
        return degatsMin;
    }

    public void setDegatsMin(int degatsMin) {
        this.degatsMin = degatsMin;
    }

    public int getDegatsMax() {
        return degatsMax;
    }

    public void setDegatsMax(int degatsMax) {
        this.degatsMax = degatsMax;
    }

    public int getNiveauUtilisationMin() {
        return niveauUtilisationMin;
    }

    public void setNiveauUtilisationMin(int niveauUtilisationMin) {
        this.niveauUtilisationMin = niveauUtilisationMin;
    }

    public boolean isMagicOuPas() {
        return magicOuPas;
    }

    public void setMagicOuPas(boolean magicOuPas) {
        this.magicOuPas = magicOuPas;
    }

    public int getTailleArme() {
        return tailleArme;
    }

    public void setTailleArme(int tailleArme) {
        this.tailleArme = tailleArme;
    }

    public NatureElement getNature() {
        return nature;
    }

    public void setNature(NatureElement nature) {
        this.nature = nature;
    }
}
