package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.PersonnageService;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;
import be.dungeon_ucm.demo.Outils.Services.LancerServiceImpl;

public class PersonnageServiceImpl implements PersonnageService {

    private LancerServiceImpl lancerServiceImpl;
    private CorpsServiceImpl corpsServiceImpl;

    @Override
    public void recupererPvPM(Personnage p, int pv, int pm) {
        if(p.getVie()){
            p.setPointDeVie(p.getPointDeVie() + pv);
            p.setPointDeMana(p.getPointDeMana() + pm);
            if(p.getPointDeVie() < p.getPointDeVieMax()){
                p.setPointDeVie(p.getPointDeVieMax());
            }
            if(p.getPointDeMana() < p.getPointDeManaMax()){
                p.setPointDeMana(p.getPointDeManaMax());
            }
        }
    } // ok

    @Override
    public void recupererPv(Personnage p, int pv) {
        if(p.getVie()){
            p.setPointDeVie(p.getPointDeVie() + pv);
        }
        if(p.getPointDeVie() < p.getPointDeVieMax()){
            p.setPointDeVie(p.getPointDeVieMax());
        }
    } // ok

    @Override
    public void recupererPM(Personnage p, int pm) {
        if(p.getVie()){
            p.setPointDeMana(p.getPointDeMana() + pm);
        }
        if(p.getPointDeMana() < p.getPointDeManaMax()){
            p.setPointDeMana(p.getPointDeManaMax());
        }
    } // ok

    @Override
    public void monteeNiveau(Personnage p, LancerDeDes de) {
        if(p.getVie()){
            p.setNiveau(p.getNiveau() + 1);
            p.setPointDeVieMax(lancerServiceImpl.lancer(de));
            p.setPointDeManaMax(lancerServiceImpl.lancer(de));
        }
    } // ok

    @Override
    public void modifierEtat(Personnage p, Etat etat) {
        p.setEtat(etat);
    } // ok

    @Override
    public void equiperArmure(Personnage p, Armure a) {
        // sac.add( =>
        corpsServiceImpl.Equiper(a,p.getCorpsAventurier());
    } // ok

    @Override
    public void equiperArme(Personnage p, Arme a) {
        // sac.add( =>
        corpsServiceImpl.Armer(a,p.getCorpsAventurier());
    } // ok

    @Override
    public void subirDegat(Personnage p,int degats) {
        
    }

    @Override
    public void equiperArmeSimple(Personnage p, Arme a) {

        // mettre arme dans sac

        p.setArme(a);
    }

    @Override
    public void equiperArmureSimple(Personnage p, Armure a) {

        // mettre armure dans sac

        p.setArmure(a);
    }

    @Override
    public int degatArme(Personnage p) {
        return p.getArme().getDegatsMax();
    }

    @Override
    public int degatArmure(Personnage p) {
        return p.getArmure().getProtection();
    }


}
