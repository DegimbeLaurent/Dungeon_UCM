package be.dungeon_ucm.demo.BL.Models.Personnage.Hero;

import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Hero extends Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Column(name = " Chance ")
    private int pointDeChance;

    // @Column(name = " Endurance ")
    private int pointDEndurance;

    // @Column(name = " Endurance Max ")
    private int pointDEnduranceMax;

    // @Column(name = " Experience ")
    private int pointDExperience;

    // @Column(name =" Experience Demandée ")
    private int pointDExperienceMax;

    public Hero() {
    }

    public Hero(String nomPersonnage, int pointDeVie, int pointDeMana,
                int pointDeForce, int pointDeAgilite, int pointDeIntelligence, int pointDeCharisme,
                int pointDeChance, int pointDEndurance) {
        super(nomPersonnage, pointDeVie, pointDeMana, pointDeForce, pointDeAgilite,
                pointDeIntelligence, pointDeCharisme);
        this.pointDeChance = pointDeChance;
        this.pointDEndurance = pointDEndurance;
        this.pointDEnduranceMax = getPointDEndurance();
        this.pointDExperience = 0;
        this.pointDExperienceMax = (getNiveau()*100);
    }


}
