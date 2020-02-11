package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;
import java.util.List;

public interface PersonnageService {

    void recupererPvPM(Personnage p,int pv, int pm);
    void recupererPv(Personnage p,int pv);
    void recupererPM(Personnage p,int pm);
    void monteeNiveau(Personnage p, LancerDeDes de);
    void modifierEtat(Personnage p, Etat etat);

    void subirDegatPhys(Personnage p,int degats);
    void subirDegatMagic(Personnage p,int degats);
    void constitutionArmure(Personnage p);
    void etatCritique(Personnage p);
    void modifierCapacite(Personnage p, int id);
    List<Integer> recuperCapacite(Personnage p);

    void equiperArmureSimple( Personnage p, Armure armure);
    void equiperArmeSimple( Personnage p, Arme arme);

    // projet pour corps couvert d'armure et arme;

    void equiperArmure(Personnage p, Armure a);
    void equiperArme(Personnage p, Arme a);
}
