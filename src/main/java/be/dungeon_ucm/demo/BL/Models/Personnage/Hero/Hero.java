package be.dungeon_ucm.demo.BL.Models.Personnage.Hero;

import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public class Hero extends Personnage {


    private long id;
    private int pointDeChance;
    private int pointDEndurance;
    private int pointDEnduranceMax;
    private int pointDExperience;
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
