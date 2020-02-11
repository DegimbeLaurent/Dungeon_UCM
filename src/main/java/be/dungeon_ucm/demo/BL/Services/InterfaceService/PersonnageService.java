package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;

public interface PersonnageService {

    void recupererPvPM(Personnage p,int pv, int pm);
    void recupererPv(Personnage p,int pv);
    void recupererPM(Personnage p,int pm);
    void monteeNiveau(Personnage p);
    String toString();
    void modifierEtat(Etat etat);


}
