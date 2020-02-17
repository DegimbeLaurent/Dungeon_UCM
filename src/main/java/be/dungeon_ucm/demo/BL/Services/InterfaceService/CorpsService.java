package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Corps;

public interface CorpsService {
    // echange arme avec celle du corps
    Armure Equiper(Armure ar, Corps c);
    // echange armure avec celle du corps
    Arme Armer(Arme ar, Corps c);
    // renvoie une phrase qui commpare les armures
    String comparerArmure(Armure ar, Corps c);
    // renvoie une phrase qui compare les armes
    String compareArme(Arme ar , Corps c);


}
