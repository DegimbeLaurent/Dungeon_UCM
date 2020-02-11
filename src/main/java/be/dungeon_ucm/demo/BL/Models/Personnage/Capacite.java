package be.dungeon_ucm.demo.BL.Models.Personnage;


import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Capacite {

    private Long id;
    private String nomCapacite;
    private int Degats;
    private int CoupCritique; // avoir avec le niv et les degat et magic ou pas
    private int niveauMin;
    private boolean degatSolAir;
    private int longeurDesDegats;
    private boolean genreMagic;
    private Etat effectCritique;
    private NatureElement nature;

    public Capacite() {
    }

    public Capacite( String nomCapacite, int degats, int coupCritique, int niveauMin, boolean degatSolAir,
                    int longeurDesDegats, boolean genreMagic, Etat effectCritique, NatureElement nature) {
        this.CoupCritique = coupCritique;
        this.Degats = degats;
        this.degatSolAir = degatSolAir;
        this.genreMagic = genreMagic;
        this.longeurDesDegats = longeurDesDegats;
        this.effectCritique = effectCritique;
        this.nature = nature;

    }


}
