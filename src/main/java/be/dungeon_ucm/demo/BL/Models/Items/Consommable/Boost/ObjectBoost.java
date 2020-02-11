package be.dungeon_ucm.demo.BL.Models.Items.Consommable.Boost;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;

public class ObjectBoost extends Consommable {

    private String label;

    private int boost;

    private String stat; // pour l'instant c 'est seulement l'endurance ;

    public ObjectBoost() {
        super();
    }

    public ObjectBoost(String nom,String label, int boost, String stat) {
        super(nom);
        this.label = label;
        this.boost = boost;
        this.stat = stat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
