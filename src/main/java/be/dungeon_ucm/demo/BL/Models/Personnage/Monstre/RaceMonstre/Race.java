package be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.RaceMonstre;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Race {

    DRAGON("Dragon",10,10,3,4,3,3,true,true,1,10,NatureElement.FEU,10),
    VACHE("Vache",10,10,3,4,3,3,true,true,1,10,NatureElement.FEU,60),
    TROLL("Troll",10,10,3,4,3,3,true,true,1,10,NatureElement.FEU,40),
    SOEUR("La soeur de Thomas",10,10,3,4,3,3,true,true,1,10,NatureElement.FEU,1);



    private String nomPersonnage;
    private int pointDeVie;
    private int pointDeMana;
    private int pointDeForce;
    private int pointDeAgilite;
    private int pointDeIntelligence;
    private int pointDeCharisme;
    private boolean volant;
    private boolean magic;
    private int niveauMonstre;
    private int expDonnee;
    private NatureElement typeDeMonstre;
    private int tauxAppartion;

}
