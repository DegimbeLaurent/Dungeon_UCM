package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.Salle;
import be.dungeon_ucm.demo.BL.Models.Donjons.TypeSalle;
import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.SallePiegeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SallePiegeServiceImpl implements SallePiegeService {

    private HeroServiceImpl heroService;

    public SallePiegeServiceImpl(HeroServiceImpl heroService) {
        this.heroService = heroService;
    }

    public Equipe trap(Equipe equipe, Donjon donjon) {

        Salle sallepiege = (Salle) donjon.getSalles().stream().filter(salle -> salle.getType().equals(TypeSalle.PIEGE));

        //Déclarations de mes variables
        List<Hero> heroList = new ArrayList<>();
        int chance = 0;
        Random rnd = new Random();

        //Je vais rechercher tous les Personnages que je cast en Heros et que je met dans une List car fuck les Tableaux !!!
        for (Personnage p : equipe.getEquipe()) {
            Hero h = (Hero) p;
            heroList.add(h);
            //Je rajoute a ma chance la chance de tous les héros de l'équipe qui ne sont pas mort
            if (p.getVie())
                chance += h.getPointDeChance();
        }

        //Je lance un random et si le nombre obtenu est plus grand que la chance de l'équipe ils subissent le piège
        int nb = rnd.nextInt(100);
        if (nb > chance) {

            for (Hero h : heroList) {

                switch (donjon.getType()) {
                    case FEU:
                        heroService.modifierEtat((Personnage) h, Etat.BRULEE);
                        break;
                    case GLACE:
                        heroService.modifierEtat((Personnage) h, Etat.GELE);
                        break;
                    case ELECTRIQUE:
                        heroService.modifierEtat((Personnage) h, Etat.CONSTIPER);
                        break;
                    //TODO Laurent rajoute chaque cas que tu veux il y en a trop !
                    default:
                        break;
                }
            }
        }
        return equipe;
    }

}
