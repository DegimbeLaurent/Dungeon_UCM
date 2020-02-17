package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Corps;

public interface CorpsService {

    Armure Equiper(Armure ar, Corps c);
    Arme Armer(Arme ar, Corps c);
    String comparerArmure(Armure ar, Corps c);
    String compareArme(Arme ar , Corps c);


}
