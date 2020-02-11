package be.dungeon_ucm.demo.DAL.Models.Personnage;

import be.dungeon_ucm.demo.DAL.Models.EtatNature.Etat;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@TableGenerator(name ="Personnage")
public abstract class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomPersonnage;

    private int pointDeVie;

    private int pointDeMana;

    private int pointDeForce;

    private int pointDeIntelligence;

    private int pointDeAgilite;

    private int pointDeCharisme;

    private int pointDeResistancePhysique;

    private int pointDeResistanceMagique;

    private int pointDeVieMax;

    private int pointDeManaMax;

    private Etat etat;

    private Boolean vie;

    private int niveau;

    public Personnage() {
    }
    public Personnage(String nomPersonnage, int pointDeVie, int pointDeMana, int pointDeForce, int pointDeAgilite,
                      int pointDeIntelligence, int pointDeCharisme){
        this.etat = Etat.NORMAL;
        this.vie = true;
        this.niveau = 1;
        this.nomPersonnage = nomPersonnage;
        this.pointDeVie = pointDeVie;
        this.pointDeMana = pointDeMana;
        this.pointDeForce = pointDeForce;
        this.pointDeAgilite = pointDeAgilite;
        this.pointDeIntelligence = pointDeIntelligence;
        this.pointDeCharisme = pointDeCharisme;
        this.pointDeResistancePhysique = 0;
        this.pointDeResistanceMagique = 0;
        this.pointDeVieMax = pointDeVie;
        this.pointDeManaMax = pointDeMana;
    }

}
