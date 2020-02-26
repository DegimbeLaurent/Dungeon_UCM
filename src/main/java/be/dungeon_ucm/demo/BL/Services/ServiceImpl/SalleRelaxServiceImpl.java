package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.HeroService;

import java.util.ArrayList;
import java.util.List;

public class SalleRelaxServiceImpl {

    private HeroServiceImpl heroService;

    public SalleRelaxServiceImpl(HeroServiceImpl heroService) {
        this.heroService = heroService;
    }

    public boolean sauvegarde(Equipe equipe){

        //TODO faire la sauvegarde
        return true;
    }

    public Equipe repos(Equipe equipe){

        List<Hero> heroList = new ArrayList<>();

        for (Personnage p : equipe.getEquipe()) {
            Hero h = (Hero)p;
            heroList.add(h);

            if (p.getVie())
                heroService.recupererPv(p , p.getPointDeVie()/2);
        }

        return equipe;
    }
}
