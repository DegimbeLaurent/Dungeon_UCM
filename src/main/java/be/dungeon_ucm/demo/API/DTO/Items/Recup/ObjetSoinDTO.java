package be.dungeon_ucm.demo.API.DTO.Items.Recup;

import be.dungeon_ucm.demo.API.DTO.Items.ConsommableDTO;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjetSoin;

public class ObjetSoinDTO extends ConsommableDTO {

    private int pointDeSoin;

    public ObjetSoinDTO(ObjetSoin objetSoin) {
        super(objetSoin);
        this.pointDeSoin=objetSoin.getPointDeSoin();
    }

    public int getPointDeSoin() {
        return pointDeSoin;
    }

    public void setPointDeSoin(int pointDeSoin) {
        this.pointDeSoin = pointDeSoin;
    }
}
