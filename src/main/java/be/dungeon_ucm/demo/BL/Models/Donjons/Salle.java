package be.dungeon_ucm.demo.BL.Models.Donjons;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;

public class Salle {

    private Long id;

    private int coordonneeX;

    private int coordonneeY;

    private TypeSalle typeSalle;

    private Equipe equipe;

    public Salle(Long id, int coordonneeX, int coordonneeY, TypeSalle typeSalle) {
        this.id = id;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.typeSalle = typeSalle;
    }

    public Salle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public int getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public TypeSalle getType() {
        return typeSalle;
    }

    public void setType(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
