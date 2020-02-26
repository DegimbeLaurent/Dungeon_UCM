package be.dungeon_ucm.demo.API.DTO.Items.Boost;

import be.dungeon_ucm.demo.API.DTO.Items.ConsommableDTO;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Boost.ObjectBoost;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;

public class ObjectBoostDTO extends ConsommableDTO {
    private String label;
    private String stat;
    private int boost;

    public ObjectBoostDTO(ObjectBoost objectBoost) {
        super(objectBoost);
        this.label = objectBoost.getLabel();
        this.stat = objectBoost.getStat();
        this.boost = objectBoost.getBoost();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }
}
