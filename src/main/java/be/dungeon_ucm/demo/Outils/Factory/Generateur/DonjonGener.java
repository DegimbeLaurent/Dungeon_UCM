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

    // Type de Salle

    // Appel la salle  type :Couloirs
    public static Salle creationDeCouloirs(int id, int poX, int poY) {
        Salle sal = new Salle();
        sal.setId((long) id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.COULOIR);
        return sal;
    }

    // Appel la salle type : recuperation
    public static Salle creationDeRelax(int id, int poX, int poY) {
        Salle sal = new Salle();
        sal.setId((long) id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.REPOS);
        return sal;
    }

    // Appel la Salle type : piege
    public static Salle creationDePiege(int id, int poX, int poY) {
        Salle sal = new Salle();
        sal.setId((long) id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.PIEGE);
        return sal;
    }

    // Appel la salle type : combat
    public static Salle creationDeCombat(int id, int poX, int poY) {
        Salle sal = new Salle();
        sal.setId((long) id);
        sal.setCoordonneeX(poX);
        sal.setCoordonneeY(poY);
        sal.setType(TypeSalle.COMBAT);
        return sal;
    }

    // Appel de salle qui sont a paramètre spéciale type Entrée , boss , mini-boss
    // Appeller lorsqu'on veut recreer un salle diffèrents des autres genre Entrée, .. etc
    public static Salle creationDautreSalle ( int id, int poX, int poY, TypeSalle type){
            Salle sal = new Salle();
            sal.setCoordonneeX(poX);
            sal.setCoordonneeY(poY);
            sal.setId((long) id);
            sal.setType(type);
            return sal;
        }

    // Remplir une Carte de Salle genre Aléatoirement

    // Creation de la map qui renvoie une list de Salle
    // list Finale : carte, list Provisoire : listeSalle
    public List<Salle> creationDeLaMap (int lvlDonjon){
        // liste avec la carte
        List<Salle> carte = new ArrayList<>();
        // liste avec les salles pas connectée
        List<Salle> listeSalle = new ArrayList<>();
        // liste des salle crée a cote des salle non connectée
        List<Salle> listeTemp = new ArrayList<>();
        // pourcentage permet de calculer si il y va avoir des salles.
        int pourcentage = 100;
        // taille de carte
        int taille = lvlDonjon*10;
        // pourcentageNbSalle est le nombre de salle a cote
        int pourcentageNbSalle;
        // position x
        int poX = lvlDonjon * 5;
        // position y
        int poY = lvlDonjon * 5;
        // proba
        int probabilite;
        // zone de la salle sur le cote droit - gauche - haut - bas
        int zoneDeLaSalle;
        // id des salle
        int id = 1;
        // Creation de la salle entree
        listeSalle.add(creationDautreSalle(id, poX, poY, TypeSalle.ENTREE));
        // ou la salle sera avec un couloir
        id ++;
        carte.add(creationDautreSalle(id,0,0,TypeSalle.COULOIR));
        // liste des zones deja prise
        List<Integer> tab = new ArrayList<>(4);
        tab.add(1);
        tab.add(2);
        tab.add(3);
        tab.add(4);
        ///////// Salle carte //////
        //tant que pourcentage >= 0 il y a des salles autour
        while (pourcentage > 0) {
            // pour chaque salle de la listeSalle on regarde si il y a
            for (Salle a : listeSalle) {
                if(contient(a,carte)) {
                    listeSalle.remove(a);
                }else {
                    // ajoute la salle dans la carte
                    carte.add(a);
                    // initie les valeur de la liste de nombre
                    tab.clear();
                    tab.add(1);
                    tab.add(2);
                    tab.add(3);
                    tab.add(4);
                    // le nombre de salle en fct de pourcentage
                    pourcentageNbSalle = pourcentage;
                    // Sur 100 il y a un % de chance
                    probabilite = new Random(100-pourcentage).nextInt();
                    // Si pourcentage <= pourcentage il y a des salles
                    if (probabilite <= pourcentage) {
                        Salle o = null;
                        // tant que pourcentageNBsalle >< 0 on cree des salle autour
                        while (pourcentageNbSalle > 0) {
                            zoneDeLaSalle = tab.get((new Random().nextInt(tab.size() - 1)));
                            for (int nombre : tab) {
                                if(nombre == zoneDeLaSalle){
                                    tab.remove(nombre);
                                }
                            }
                            switch (zoneDeLaSalle) {
                                // en haut
                                case 1:
                                    o = instancierLesCoordonnee(lvlDonjon,a,id,0,1);
                                    break;
                                // en bas
                                case 2:
                                    o = instancierLesCoordonnee(lvlDonjon,a,id,0,-1);
                                    break;
                                // droite
                                case 3:
                                    o = instancierLesCoordonnee(lvlDonjon,a,id,1,0);
                                    break;
                                // gauche
                                default:
                                    o = instancierLesCoordonnee(lvlDonjon,a,id,-1,0);
                                    break;
                            }
                            // liste des proba
                            if(o != null){
                                listeTemp.add(o);
                            }

                            // % de salle max 4
                            pourcentageNbSalle -= 25;
                        }
                    }
                }
            }
            // on peut supprimer toute les salles
            listeSalle.clear();
            // On ajoute les nouvelles salles si l'enplacement est pas vide
            for (Salle b : listeTemp){
                if(contient(b,carte)) {
                    listeTemp.remove(b);
                }else{
                    listeSalle.add(b);
                }
            }
            // vide la liste de salle
            listeTemp.clear();
            // pourcentage de salle dans le dj
            pourcentage -= 20 / lvlDonjon;
        }

        return carte;
    }

    // Méthode static qui verifie Si une salle est bien dans la liste
    public static boolean contient (Salle salle, List <Salle> carte){
            boolean cont = false;
            for (Salle a : carte) {
                if (a.getCoordonneeX() == salle.getCoordonneeX()) {
                    if (a.getCoordonneeY() == salle.getCoordonneeY()) {
                        cont = true;
                    }
                }
            }
            return cont;
        }
    // remplir de valeur
    public static Salle instancierLesCoordonnee(int lvlDonjon, Salle a,int id, int posiX, int posiY ){
        Salle o = null;
        if(posiX != (lvlDonjon*10) && posiY != (lvlDonjon*10)) {
            posiX = a.getCoordonneeX() + posiX;
            posiY = a.getCoordonneeY() + posiY;
            o = ajoutDelaSalle(id++, posiX, posiY);
        }
        return o;
    }

    // type de salle Spécial
    // Creation d'un salle en utilisisant les méthodes de Salle Type
    public static Salle ajoutDelaSalle (int a, int poXpres, int poYpres){
            Salle salle = null;
            int pourcentage = new Random(100).nextInt();
            if (pourcentage < 15) {
                salle = creationDePiege(a, poXpres, poYpres);
            } else if (pourcentage > 15 && pourcentage < 75) {
                salle = creationDeCombat(a, poXpres, poYpres);
            } else if (pourcentage > 75 && pourcentage <= 100) {
                salle = creationDeRelax(a, poXpres, poYpres);
            }
            return salle;
        }
        

    // Méthode de creation du Donjon

    // Zone de creation du donjon ou on le replit grace a la  creationDeLaMap
    public Donjon creationDeDonjon ( int lvlDonjon, NatureElement natureElement){
        Donjon dj = new Donjon();
        dj.setNiveau(lvlDonjon);
        dj.setNom("Donjon" + natureElement.name());
        dj.setType(natureElement);
        dj.setId(1L); // A mettre dans la DB
        dj.setSalles(creationDeLaMap(lvlDonjon));
        return dj;
    }

}


