package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;

public interface HeroService extends PersonnageService {

    // Chaque action coute un PE au Hero
    void actionHero(Hero h);

    // Montée de niveau du hero
    void monteeNiveau(Hero h, LancerDeDes de);

    // Recuperation de PE
    void RecupEndurance(Hero h, int pe);

}
