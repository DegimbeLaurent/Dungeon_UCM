package be.dungeon_ucm.demo.DAL.Models.Items.Consommable.Recup;

import be.dungeon_ucm.demo.DAL.Models.Items.Consommable.Consommable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ObjectRecupStat extends Consommable {

    private String stat;

    private int regenerationStat;

    public ObjectRecupStat(String nom, String stat, int recuperation) {
        super(nom);
        this.stat = stat;
        this.regenerationStat = recuperation;
    }

    public ObjectRecupStat() {
       super();
    }

}
