package be.dungeon_ucm.demo.DAL.Models.Items.Consommable;

import be.dungeon_ucm.demo.DAL.Models.Items.ItemBasique;

public class Consommable extends ItemBasique {

    public Consommable(String nom) {
        super(nom);
        setDurablilite(1);
    }

    public Consommable() {
        super();
        setDurablilite(1);
    }
}
