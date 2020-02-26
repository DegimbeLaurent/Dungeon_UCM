package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.TypeSalle;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;

public class SalleBossServiceImpl {

    private MonstreGener monstreGener;

    public SalleBossServiceImpl(MonstreGener monstreGener) {
        this.monstreGener = monstreGener;
    }

    public Monstre getBoss(){
        Donjon donjon = new Donjon();
        Monstre monstre = monstreGener.getMonstre(NatureElement.FEU,donjon.getNiveau());

        monstre.setPointDeVie(monstre.getPointDeVie()*2);
        monstre.setPointDeForce(monstre.getPointDeForce()*2);
        monstre.setPointDeIntelligence(monstre.getPointDeIntelligence()*2);
        monstre.setPointDeAgilite(monstre.getPointDeAgilite()*2);
        monstre.setPointDeResistancePhysique(monstre.getPointDeResistancePhysique()*2);
        monstre.setPointDeResistanceMagique(monstre.getPointDeResistanceMagique()*2);

        monstre.setExpDonnee(monstre.getNiveauMonstre()*50);
//        monstre.setPointDeCharisme();
//        monstre.setVie();
//        monstre.setPointDeMana();
//        monstre.setPointDeVieMax();
//        monstre.setPointDeManaMax();
        return monstre;
    }
}
