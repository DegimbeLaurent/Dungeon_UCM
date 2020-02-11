package be.dungeon_ucm.demo.BL.Models.Items.Equipement;

import be.dungeon_ucm.demo.BL.Models.Items.ItemBasique;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

public class Armure extends ItemBasique {

    private int protection;

    private int niveauUtilisationMin;

    private String zone; // zone ou on met l'armure

    private boolean magicArmure;

    public Armure(String nom, int durablilite, int protection, int niveauUtilisationMin, boolean magicArmure) {
        super(nom, durablilite);
        this.protection = protection;
        this.magicArmure = magicArmure;
        this.niveauUtilisationMin = niveauUtilisationMin;
    }

    public Armure() {
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getNiveauUtilisationMin() {
        return niveauUtilisationMin;
    }

    public void setNiveauUtilisationMin(int niveauUtilisationMin) {
        this.niveauUtilisationMin = niveauUtilisationMin;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public boolean isMagicArmure() {
        return magicArmure;
    }

    public void setMagicArmure(boolean magicArmure) {
        this.magicArmure = magicArmure;
    }
}
