package be.dungeon_ucm.demo.API.DTO.donjonDTO;


import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.Salle;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;

public class DonjonDTO {

    private Donjon donjon;
    private Salle salle;

    public DonjonDTO(Donjon donjon, Salle salle) {
        this.donjon = donjon;
        this.salle = salle;
    }

    public DonjonDTO() {
    }

    public Donjon getDonjon() {
        return donjon;
    }

    public void setDonjon(Donjon donjon) {
        this.donjon = donjon;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}

