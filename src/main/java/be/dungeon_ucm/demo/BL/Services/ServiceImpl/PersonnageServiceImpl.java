package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.PersonnageService;

public class PersonnageServiceImpl implements PersonnageService {


    @Override
    public void recupererPvPM(Personnage p, int pv, int pm) {
        if(p.getVie()){
            p.setPointDeVie(p.getPointDeVie() + pv);
            p.setPointDeMana(p.getPointDeMana() + pm);
        }
    } // ok

    @Override
    public void recupererPv(Personnage p, int pv) {
        if(p.getVie()){
            p.setPointDeVie(p.getPointDeVie() + pv);
        }
    } // ok

    @Override
    public void recupererPM(Personnage p, int pm) {
        if(p.getVie()){
            p.setPointDeMana(p.getPointDeMana() + pm);
        }
    } // ok

    @Override
    public void monteeNiveau(Personnage p) {

    }

    @Override
    public void modifierEtat(Etat etat) {

    }
}
