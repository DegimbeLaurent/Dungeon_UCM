package be.dungeon_ucm.demo.DAL.Models.Items;

import be.dungeon_ucm.demo.DAL.Models.Items.Loot.Ingrediant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public abstract class ItemBasique {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name =" durabilité ")
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
