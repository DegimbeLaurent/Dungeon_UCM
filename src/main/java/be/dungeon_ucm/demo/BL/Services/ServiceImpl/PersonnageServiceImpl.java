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
    public void subirDegatPhys(Personnage p,int degats){
        p.setPointDeVie(p.getPointDeVie() - (degats - p.getPointDeResistancePhysique()));
    } // ok

    @Override
    public void subirDegatMagic(Personnage p,int degats){
        p.setPointDeVie(p.getPointDeVie() - (degats - p.getPointDeResistanceMagique()));
    } // ok

    @Override
    public void constitutionArmure(Personnage p) {
        p.setPointDeResistancePhysique(0);
        p.setPointDeResistancePhysique(0);
        for (Armure a : p.getCorpsAventurier().getArmures()) {
            if(a.isMagicArmure()){
                p.setPointDeResistanceMagique(p.getPointDeResistanceMagique() + a.getProtection());
            }else{
                p.setPointDeResistancePhysique(p.getPointDeResistancePhysique() + a.getProtection());
            }
        }
    }

    @Override
    public void etatCritique(Etat p) {

    }

    @Override
    public void equiperArmureSimple(Personnage p,Armure armure) {
        // mettre arme dans sac
        p.setCorps(armure);
    }

    @Override
    public void equiperArmeSimple(Personnage p, Arme arme) {
        // mettre armure dans sac
        p.setArme(arme);
    }


    // Suite du projet Armure sur e corps

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
}
