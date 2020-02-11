package be.dungeon_ucm.demo.BL.Models.Personnage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pnj extends Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String metier;

    private String label;

    private String option;

    public Pnj() {

    }
    public Pnj(String metier, String label, String option) {
        this.option = option;
        this.metier = metier;
        this.label = label;
    }
}
