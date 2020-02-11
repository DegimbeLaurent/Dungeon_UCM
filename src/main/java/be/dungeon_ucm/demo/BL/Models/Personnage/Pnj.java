package be.dungeon_ucm.demo.BL.Models.Personnage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pnj extends Personnage {

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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
