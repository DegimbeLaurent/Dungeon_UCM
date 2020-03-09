package be.dungeon_ucm.demo.BL.Services.DonjonGestion;

import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.Salle;
import be.dungeon_ucm.demo.BL.Models.Donjons.TypeSalle;
import org.springframework.stereotype.Component;

/*
    contient les méthode qui simplifie les interaction avec la BL
    Et des méthode de modif
 */
@Component
public class LanceDonjon {

    public void modifTypeDeSalle(Salle salleDuDonjon){
        // la salle du couloir ne doit pas chgt
        if(salleDuDonjon.getType() != TypeSalle.COULOIR){
            // SI c'est une entree Donc pas une sortie
            if(salleDuDonjon.getType() == TypeSalle.ENTREE){
                typeDeSalleEntree(salleDuDonjon);
                // la salle repos ne change pas si tout change
            }else if(salleDuDonjon.getType() != TypeSalle.REPOS){
                typeDeSalle(salleDuDonjon);
            }
        }
    }

    // Si la salle est l'entree => salle Repos
    // Car il y a la possibilité d ajouter un type de salle
    public void typeDeSalleEntree(Salle salledeDonjon){
        salledeDonjon.setType(TypeSalle.REPOS);
    }
    // Si la salle est différente du couloirs
    public static Salle typeDeSalle(Salle salleDeDonjon){
        salleDeDonjon.setType(TypeSalle.VIDE);
        return salleDeDonjon;
    }



}
