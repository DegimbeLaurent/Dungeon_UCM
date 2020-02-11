package be.dungeon_ucm.demo.BL.Models.Items;

import be.dungeon_ucm.demo.BL.Models.Items.Loot.Ingrediant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public  class ItemBasique {

    private Long id;

    private int durablilite;

    private Ingrediant ingrediant; // Liste des ingredient pour le recuperer

    private String nom;

    public ItemBasique(String  nom) {
        this.nom = nom;
    }

    public ItemBasique(String  nom, int durablilite) {
        this.nom = nom;
        this.durablilite = durablilite;
    }

    public ItemBasique() {

    }
}
