package be.dungeon_ucm.demo.Outils.Services;

import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;

public interface LancerService {

    int lancer(LancerDeDes de);
    void modifierTout(LancerDeDes de,int max, int min);
    void modifierMax(LancerDeDes de, int max);
    void modifierMin(LancerDeDes de,int min);
}
