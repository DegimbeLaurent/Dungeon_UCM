package be.dungeon_ucm.demo.BL.Models.Personnage;

import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;


import java.util.List;


public class Corps {

    private List<Arme> armes;
    private List<Armure> armures;

    public Corps(List<Arme> Armes, List<Armure> armures) {
        this.armes = armes;
        this.armures = armures;
    }

    public List<Arme> getMain() {
        return armes;
    }

    public void setMain(List<Arme> armes) {
        this.armes = armes;
    }

    public List<Armure> getArmures() {
        return armures;
    }

    public void setArmures(List<Armure> armures) {
        this.armures = armures;
    }
}
