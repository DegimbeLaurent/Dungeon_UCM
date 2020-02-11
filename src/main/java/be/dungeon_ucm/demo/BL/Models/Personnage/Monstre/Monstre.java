package be.dungeon_ucm.demo.BL.Models.Personnage.Monstre;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Models.RaceMonstre.Race;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Monstre extends Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Column(name = " Monstre Volant ")
    private boolean volant;

    // @Column(name = " Monstre Magique ")
    private boolean magic;

    // @Column(name = " Niveau du donjon ")
    private int niveauMonstre;

    // @Column(name = "Experiance Donnée ")
    private int expDonnee;

    // @Column(name= " Race " )
    private Race race;

    // @Column( name = " Nature Donjon ")
    private NatureElement typeDeMonstre;

    public Monstre() {
    }

    public Monstre(String nomPersonnage, int pointDeVie, int pointDeMana, int pointDeForce, int pointDeAgilite,
                   int pointDeIntelligence, int pointDeCharisme, boolean volant, boolean magic, int niveauMonstre,
                   int expDonnee, Race race, NatureElement typeDeMonstre ) {
        super(nomPersonnage, pointDeVie, pointDeMana, pointDeForce, pointDeAgilite, pointDeIntelligence, pointDeCharisme);
        setNiveau(niveauMonstre);
        this.expDonnee = expDonnee; // fonction du niveau et de la race ( point appar )
        this.magic = magic;
        this.typeDeMonstre = typeDeMonstre;
        this.race = race;
        this.volant = volant;

    }
}
