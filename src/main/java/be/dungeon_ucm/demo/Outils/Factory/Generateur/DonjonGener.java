package be.dungeon_ucm.demo.Outils.Factory.Generateur;

import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.Salle;
import be.dungeon_ucm.demo.BL.Models.Donjons.TypeSalle;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DonjonGener {

    // Appel la salle Couloirs
    public Salle creationDeCouloirs(int id ,int poX,int poY){
        Salle sal = new Salle();
        sal.setId((long)id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.COULOIR);
        return sal;
    }

    // Appel la salle avec la recuperation
    public Salle creationDeRelax(int id ,int poX,int poY){
        Salle sal = new Salle();
        sal.setId((long)id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.REPOS);
        return sal;
    }

    // Appel la Salle avec le piege
    public Salle creationDePiege(int id ,int poX,int poY){
        Salle sal = new Salle();
        sal.setId((long)id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.PIEGE);
        return sal;
    }

    // Appel la salle qui fait les Combats
    public Salle creationDeCombat(int id ,int poX,int poY){
        Salle sal = new Salle();
        sal.setId((long)id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.COMBAT);
        return sal;
    }

    // Appeller lorsqu'on veut recreer un salle diffèrents des autres genre Entrée, .. etc
    public Salle creationDautreSalle(int id ,int poX, int poY, TypeSalle type){
        Salle sal = new Salle();
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setId((long)id);
        sal.setType(type);
        return sal;
    }

    // Creation de la map qui renvoie une list de Salle
    // list Finale : carte, list Provisoire : listeSalle
    public List<Salle> creationDeLaMap(int lvlDonjon){
        List<Salle> carte = new ArrayList<>();
        List<Salle> listeSalle = new ArrayList<>();
        int pourcentage = 100 , pourcentageNbSalle, poX = lvlDonjon*5, poY = lvlDonjon*5, probabilite, zoneDeLaSalle, id = 1;
        listeSalle.add(creationDautreSalle(id,poX,poY,TypeSalle.ENTREE));

        while(pourcentage > 0){

            for (Salle a: listeSalle){
                pourcentageNbSalle = pourcentage;
                probabilite = new Random(100).nextInt();

                if(probabilite < pourcentage){

                    while(pourcentageNbSalle > 0){

                        zoneDeLaSalle = new Random(4).nextInt();

                        switch (zoneDeLaSalle){

                            case 1:

                                break;

                            case 2:

                                break;

                            case 3:

                                break;

                            default:

                                break;
                        }
                        pourcentageNbSalle -= 20;
                    }
                }
            }



            pourcentage -= 20/lvlDonjon;
        }


        return carte;
    }

    public static boolean contient(Salle salle, List<Salle> carte){
        boolean cont = false;
        for (Salle a : carte) {
            if(a.getCoordonneeX() == salle.getCoordonneeX()){
                if(a.getCoordonneeY() == salle.getCoordonneeY()){
                    cont = true;
                }
            }
        }
        return cont;
    }


    // Ajoute une salle au hasard dans le donjon parmi une autre
    public Salle ajoutDelaSalle(int a,int poXpres, int poYpres){
        Salle salle = null;
        int pourcentage = new Random(100).nextInt();
        if(pourcentage < 15){
            salle = creationDePiege(a,poXpres,poYpres);
        }else if(pourcentage > 15 && pourcentage < 75){
            salle = creationDeCombat(a,poXpres,poYpres);
        }else if(pourcentage > 75 && pourcentage <= 100){
            salle = creationDeRelax(a,poXpres,poYpres);
        }
        return salle;
    }

    // Zone de creation du donjon ou on le replit grace a la  creationDeLaMap
    public Donjon creationDeDonjon(int lvlDonjon, NatureElement natureElement){
        Donjon dj = new Donjon();
        dj.setNiveau(lvlDonjon);
        dj.setNom("Donjon" + natureElement.name());
        dj.setType(natureElement);
        dj.setId(1L); // A mettre dans la DB
        dj.setSalles(creationDeLaMap(lvlDonjon));
        return dj;
    }

}

