package be.dungeon_ucm.demo.BL.Models.Personnage.Monstre;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.RaceMonstre.Race;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class Monstre extends Personnage {

    private long id;
    private boolean volant;

    private boolean magic;

    private int niveauMonstre;

    private int expDonnee;

    private Race race;

    private NatureElement typeDeMonstre;

    private int tauxAppartion;

    public Monstre() {
    }

    public Monstre(Race type) {
        super(type.getNomPersonnage(),type.getPointDeVie(), type.getPointDeMana(), type.getPointDeForce(), type.getPointDeAgilite(), type.getPointDeIntelligence(), type.getPointDeCharisme());
        setNiveau(niveauMonstre);
        this.expDonnee = type.getExpDonnee(); // fonction du niveau et de la race ( point appar )
        this.magic = type.isMagic();
        this.typeDeMonstre = type.getTypeDeMonstre();
        this.volant = type.isVolant();
        this.expDonnee = expDonnee; // fonction du niveau et de la race ( point appar )
        this.magic = magic;
        this.typeDeMonstre = typeDeMonstre;
        this.race = race;
        this.volant = volant;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public boolean isVolant() {
        return volant;
    }

    public void setVolant(boolean volant) {
        this.volant = volant;
    }

    public boolean isMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public int getNiveauMonstre() {
        return niveauMonstre;
    }

    public void setNiveauMonstre(int niveauMonstre) {
        this.niveauMonstre = niveauMonstre;
    }

    public int getExpDonnee() {
        return expDonnee;
    }

    public void setExpDonnee(int expDonnee) {
        this.expDonnee = expDonnee;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public NatureElement getTypeDeMonstre() {
        return typeDeMonstre;
    }

    public void setTypeDeMonstre(NatureElement typeDeMonstre) {
        this.typeDeMonstre = typeDeMonstre;
    }
}
