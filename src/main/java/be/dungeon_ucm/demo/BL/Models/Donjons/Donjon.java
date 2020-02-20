package be.dungeon_ucm.demo.BL.Models.Donjons;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;

import java.util.List;


public class Donjon {

    private Long id;

    private String nom;

    private NatureElement type;

    private int niveau;

    List<Salle> salles;

    public Donjon(Long id, String nom, NatureElement type, int niveau, List<Salle> salles )  {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
        this.salles = salles;
    }

    public Donjon() {
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NatureElement getType() {
        return type;
    }

    public void setType(NatureElement type) {
        this.type = type;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
