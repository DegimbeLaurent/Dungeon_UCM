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

    private long id;
    private String nomCapacite;
    private int degats;
    private int CoupCritique; // avoir avec le niv et les degat et magic ou pas
    private int niveauMin;
    private boolean degatSolAir;
    private int longeurDesDegats;
    private boolean genreMagic;
    private Etat effectCritique; // ENUN
    private NatureElement nature; // ENUN

    public Capacite() {
    }

    public Capacite( String nomCapacite, int degats, int coupCritique, int niveauMin, boolean degatSolAir,
                    int longeurDesDegats, boolean genreMagic, Etat effectCritique, NatureElement nature) {
        this.CoupCritique = coupCritique;
        this.degats = degats;
        this.degatSolAir = degatSolAir;
        this.genreMagic = genreMagic;
        this.longeurDesDegats = longeurDesDegats;
        this.effectCritique = effectCritique;
        this.nature = nature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomCapacite() {
        return nomCapacite;
    }

    public void setNomCapacite(String nomCapacite) {
        this.nomCapacite = nomCapacite;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        degats = degats;
    }

    public int getCoupCritique() {
        return CoupCritique;
    }

    public void setCoupCritique(int coupCritique) {
        CoupCritique = coupCritique;
    }

    public int getNiveauMin() {
        return niveauMin;
    }

    public void setNiveauMin(int niveauMin) {
        this.niveauMin = niveauMin;
    }

    public boolean isDegatSolAir() {
        return degatSolAir;
    }

    public void setDegatSolAir(boolean degatSolAir) {
        this.degatSolAir = degatSolAir;
    }

    public int getLongeurDesDegats() {
        return longeurDesDegats;
    }

    public void setLongeurDesDegats(int longeurDesDegats) {
        this.longeurDesDegats = longeurDesDegats;
    }

    public boolean isGenreMagic() {
        return genreMagic;
    }

    public void setGenreMagic(boolean genreMagic) {
        this.genreMagic = genreMagic;
    }

    public Etat getEffectCritique() {
        return effectCritique;
    }

    public void setEffectCritique(Etat effectCritique) {
        this.effectCritique = effectCritique;
    }

    public NatureElement getNature() {
        return nature;
    }

    public void setNature(NatureElement nature) {
        this.nature = nature;
    }
}
