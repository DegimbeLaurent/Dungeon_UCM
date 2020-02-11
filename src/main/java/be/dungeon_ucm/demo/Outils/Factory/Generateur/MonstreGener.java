package be.dungeon_ucm.demo.Outils.Factory.Generateur;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.RaceMonstre.Race;

import java.security.SecureRandom;
import java.util.Random;

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
        return monstre;
    }

    public Equipe DesMonstre(NatureElement type , int lvldonjon, int nbr){
        Monstre[] monstres = new Monstre[nbr-1];
        for (int i = 0; i < nbr; i++) {
            monstres[i] = getMonstre(type,lvldonjon);
        }
        return new Equipe(false,monstres);
    }
    public int rand(int max){
        Random r = new Random();
        return 0 + r.nextInt(max - 0);
    }
}
