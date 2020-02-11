package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;

public interface PersonnageService {

    void recupererPvPM(Personnage p,int pv, int pm);
    void recupererPv(Personnage p,int pv);
    void recupererPM(Personnage p,int pm);
    void monteeNiveau(Personnage p, LancerDeDes de);
    String toString();
    void modifierEtat(Personnage p, Etat etat);
    void equiperArmure(Personnage p, Armure a);
    void equiperArme(Personnage p, Arme a);

}
