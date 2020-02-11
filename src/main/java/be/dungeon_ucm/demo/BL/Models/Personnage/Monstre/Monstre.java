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


@Getter
@Setter
public class Monstre extends Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    }
}
