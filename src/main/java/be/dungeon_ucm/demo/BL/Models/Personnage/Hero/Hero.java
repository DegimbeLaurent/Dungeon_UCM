package be.dungeon_ucm.demo.BL.Models.Personnage.Hero;

import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getPointDeChance() {
        return pointDeChance;
    }

    public void setPointDeChance(int pointDeChance) {
        this.pointDeChance = pointDeChance;
    }

    public int getPointDEndurance() {
        return pointDEndurance;
    }

    public void setPointDEndurance(int pointDEndurance) {
        this.pointDEndurance = pointDEndurance;
    }

    public int getPointDEnduranceMax() {
        return pointDEnduranceMax;
    }

    public void setPointDEnduranceMax(int pointDEnduranceMax) {
        this.pointDEnduranceMax = pointDEnduranceMax;
    }

    public int getPointDExperience() {
        return pointDExperience;
    }

    public void setPointDExperience(int pointDExperience) {
        this.pointDExperience = pointDExperience;
    }

    public int getPointDExperienceMax() {
        return pointDExperienceMax;
    }

    public void setPointDExperienceMax(int pointDExperienceMax) {
        this.pointDExperienceMax = pointDExperienceMax;
    }
}
