package be.dungeon_ucm.demo.API.DTO.Items;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;

public class ConsommableDTO {

    private long id;
    private String nom;
    private int durabilite;

    public ConsommableDTO(Consommable consommable){
        this.id=consommable.getId();
        this.nom=consommable.getNom();
        this.durabilite=consommable.getDurablilite();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDurabilite() {
        return durabilite;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }
}
