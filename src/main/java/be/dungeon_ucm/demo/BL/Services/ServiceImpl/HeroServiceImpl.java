package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.HeroService;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;
import be.dungeon_ucm.demo.Outils.Services.LancerServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private PersonnageServiceImpl personnageService;
    private LancerServiceImpl lancerService;

    @Override
    public void actionHero(Hero h) {
        if(h.getPointDEndurance() < 0) {
            h.setPointDEndurance(h.getPointDEndurance() - 1);
        }
    }
    @Override
    public void monteeNiveau(Hero h, LancerDeDes de) {
        if(h.getPointDExperience() <= h.getPointDExperienceMax()){
            h.setPointDExperience(h.getPointDExperience() - h.getPointDExperienceMax());
            personnageService.monteeNiveau(h,de);
            h.setPointDEnduranceMax(lancerService.lancer(de) + h.getPointDEnduranceMax());
            h.setPointDExperienceMax(h.getNiveau() * 100);
        }
    }

    @Override
    public void GainXp(Hero h, int xp, LancerDeDes de) {
        h.setPointDExperience(xp);
        if(h.getPointDExperience() >= h.getPointDExperienceMax()){
            h.setPointDExperience(h.getPointDExperience()-h.getPointDExperienceMax());
            monteeNiveau(h,de);
        }
    }

    @Override
    public void RecupEndurance(Hero h, int pe) {
        if(h.getVie()){
            h.setPointDEndurance(pe + h.getPointDEndurance());
        }
        if(h.getPointDEnduranceMax() < h.getPointDEndurance()){
            h.setPointDEndurance(h.getPointDEnduranceMax());
        }
    }
    @Override
    public void recupererPvPM(Personnage p, int pv, int pm) {
        personnageService.recupererPvPM(p,pv,pm);
    }
    @Override
    public void recupererPv(Personnage p, int pv) {
        personnageService.recupererPv(p,pv);
    }
    @Override
    public void recupererPM(Personnage p, int pm) {
        personnageService.recupererPM(p, pm);
    }
    @Override
    public void monteeNiveau(Personnage p, LancerDeDes de) {
        personnageService.monteeNiveau(p,de);
    }
    @Override
    public void modifierEtat(Personnage p, Etat etat) {
        personnageService.modifierEtat(p, etat);
    }
    @Override
    public void subirDegatPhys(Personnage p, int degats) {
        personnageService.subirDegatPhys(p,degats);
    }
    @Override
    public void subirDegatMagic(Personnage p, int degats) {
        personnageService.subirDegatMagic(p, degats);
    }
    @Override
    public List<Capacite> recupererCapacite(Personnage p) {
        return personnageService.recupererCapacite(p);
    }
    @Override
    public void etatSouffrant(Personnage p) {
        personnageService.etatSouffrant(p);
    }

    @Override
    public void degatDeCapacite(Personnage p, Capacite c) {
        personnageService.degatDeCapacite(p, c);
    }

    @Override
    public void equiperArmeSimple(Personnage p, Arme a) {
        personnageService.equiperArmeSimple(p,a);
    }
    @Override
    public void equiperArmureSimple(Personnage p, Armure a) {
        personnageService.equiperArmureSimple(p,a);
    }
    @Override
    public int degatArme(Personnage p) {
        return personnageService.degatArme(p);
    }
    @Override
    public int degatArmure(Personnage p) {
        return personnageService.degatArmure(p);
    }
    @Override
    public void equiperArmure(Personnage p, Armure a) {
        personnageService.equiperArmure(p,a);
    }
    @Override
    public void equiperArme(Personnage p, Arme a) {
        personnageService.equiperArme(p,a);
    }



}
