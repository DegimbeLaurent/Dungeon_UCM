package be.dungeon_ucm.demo.BL.Models.Donjons;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;

public class Salle {

    private Long id;

    private int coordonneeX;

    private int coordonneeY;

    private String type;

    public Salle(Long id, int coordonneeX, int coordonneeY, String type) {
        this.id = id;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
