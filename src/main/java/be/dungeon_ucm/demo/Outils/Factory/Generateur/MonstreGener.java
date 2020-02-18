package be.dungeon_ucm.demo.Outils.Factory.Generateur;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.RaceMonstre.Race;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Component
public class MonstreGener{

    public Monstre randMonstre(NatureElement type){
        SecureRandom random = new SecureRandom();
        int compt = 0;
        for (Race monstre: Race.values()) {
            if(monstre.getTypeDeMonstre().equals(NatureElement.NEUTRE)){
                compt+=monstre.getTauxAppartion();
            }
            if(monstre.getTypeDeMonstre().equals(type)){
                compt+=monstre.getTauxAppartion();
            }
        }
        int rest = rand(compt);
        compt=0;
        for (Race monstre: Race.values()) {
            if(monstre.getTypeDeMonstre().equals(type)){
                compt+=monstre.getTauxAppartion();
                if(compt<rest&compt>=rest-monstre.getTauxAppartion()){
                    return new Monstre(monstre);
                }
            }
        }
        return new Monstre(Race.SOEUR);
    }
    public Monstre getMonstre(NatureElement type ,int lvldonjon){

        Monstre monstre = randMonstre(type);
        monstre.setPointDeAgilite(monstre.getPointDeAgilite()*lvldonjon);
        monstre.setPointDeCharisme(monstre.getPointDeCharisme()*lvldonjon);
        monstre.setPointDeForce(monstre.getPointDeForce()*lvldonjon);
        monstre.setPointDeIntelligence(monstre.getPointDeIntelligence()*lvldonjon);
        monstre.setPointDeManaMax(monstre.getPointDeManaMax()*(lvldonjon/2));
        monstre.setPointDeVieMax(monstre.getPointDeVieMax()*(lvldonjon/2));
        monstre.setPointDeResistanceMagique(monstre.getPointDeResistanceMagique()*lvldonjon);
        monstre.setPointDeResistancePhysique(monstre.getPointDeResistancePhysique()*lvldonjon);
        monstre.setTypeDeMonstre(type);
        Capacite capacite1 = new Capacite("boule de feu",6,10,1,false,1,true, Etat.BRULEE, NatureElement.FEU);
        Capacite capacite2 = new Capacite("boule de glace",6,10,1,false,1,true,Etat.GELE, NatureElement.GLACE);
        Capacite capacite3 = new Capacite("coup de pied",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        Capacite capacite4 = new Capacite("coup de tête",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        List<Capacite> capacites = null;
        capacites.add(capacite1);
        capacites.add(capacite2);
        capacites.add(capacite3);
        capacites.add(capacite4);
        monstre.setCapacites(capacites);
        return monstre;
    }

    public Personnage[] DesMonstre(NatureElement type , int lvldonjon, int nbr){
        Monstre[] monstres = new Monstre[nbr-1];
        for (int i = 0; i < nbr; i++) {
            monstres[i] = getMonstre(type,lvldonjon);
        }
        return monstres;
    }
    public int rand(int max){
        Random r = new Random();
        return r.nextInt(max - 0);
    }
}
