package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.PersonnageService;
import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;
import be.dungeon_ucm.demo.Outils.Services.LancerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageServiceImpl implements PersonnageService {

    private LancerServiceImpl lancerServiceImpl;

    private CorpsServiceImpl corpsServiceImpl;


    @Override
    public void recupererPvPM(Personnage p, int pv, int pm) {
            p.setPointDeVie(p.getPointDeVie() + pv);
            p.setPointDeMana(p.getPointDeMana() + pm);
            if(p.getPointDeVie() < p.getPointDeVieMax()){
                p.setPointDeVie(p.getPointDeVieMax());
            }
            if(p.getPointDeMana() < p.getPointDeManaMax()){
                p.setPointDeMana(p.getPointDeManaMax());
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
    public void etatSouffrant(Personnage p) {
        p.setPointDeVie(p.getPointDeVie() - p.getEtat().getInfluenceEtat());
        if(p.getPointDeVie() <= 0){
            p.setEtat(Etat.MORT);
        }
    }
    @Override
    public void degatDeCapacite(Personnage p, Capacite c) {
        if(!c.isGenreMagic()){
            subirDegatPhys(p, c.getDegats());
        }else{
            subirDegatMagic(p, c.getDegats());
        }
    }
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
    public void subirDegatPhys(Personnage p,int degats) {
        p.setPointDeVie(p.getPointDeVie() + p.getPointDeResistancePhysique() - degats);
    }
    @Override
    public void subirDegatMagic(Personnage p, int degats) {
        p.setPointDeVie(p.getPointDeVie() + p.getPointDeResistanceMagique() - degats);
    }
    @Override
    public List<Capacite> recupererCapacite(Personnage p) {
        return p.getCapacites();
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
