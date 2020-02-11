package be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ObjetSoin  extends Consommable {

    private int pointDeSoin;

    public ObjetSoin() {
        super();
    }

    public ObjetSoin(String nom, int soin) {
        super(nom);
        this.pointDeSoin = soin;
    }
}
