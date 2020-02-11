package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;

public interface HeroService extends PersonnageService {

    void actionHero(Hero h);
    void monteeNiveau(Hero h, LancerDeDes de);
    void RecupEndurance(Hero h, int pe);
}
