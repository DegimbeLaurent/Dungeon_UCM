package be.dungeon_ucm.demo.BL.Services.ServiceImpl;

import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Arme;
import be.dungeon_ucm.demo.BL.Models.Items.Equipement.Armure;
import be.dungeon_ucm.demo.BL.Models.Personnage.Corps;
import be.dungeon_ucm.demo.BL.Services.InterfaceService.CorpsService;

public class CorpsServiceImpl implements CorpsService {

    @Override
    public Armure Equiper(Armure ar, Corps c) {
        Armure ancienne = ar;

        for (Armure a : c.getArmures()){
            if(a.getZone() == ar.getZone()) {
                ancienne = a;
                c.getArmures().remove(a);
                c.getArmures().add(ar);
            }
        }
        return ancienne;
    }

    @Override
    public Arme Armer(Arme ar, Corps c) {
        Arme ancien = ar;
        int valeur = 0;
        for (Arme a : c.getMain()) {
            valeur =+ a.getTailleArme();
        }
        switch (valeur){
            case 1 :
                if(ar.getTailleArme() == 1){
                    c.getMain().add(ar);
                    ancien = null;
                }else{

                    c.getMain().add(ar);
                    for (Arme a: c.getMain()) {
                        ancien = a;
                        c.getMain().clear();
                        c.getMain().add(ar);
                    }
                }
                break;
            case 2 :
                c.getMain().clear();
                c.getMain().add(ar);
                break;
            default:
                c.getMain().add(ar);
                ancien = null;
                break;
        }
        return ancien;
    }

    @Override
    public void comparerArmure(Armure ar, Corps c) {
        for (Armure a: c.getArmures()) {
            if(a.getZone() == ar.getZone()){
                if(a.getProtection() < ar.getProtection()){
                    // ecrire quelque chose
                }
            }

        }
    }

    @Override
    public void compareArme(Arme ar, Corps c) {
        for (Arme a: c.getMain()) {
            if(a.getDegatsMax() < ar.getDegatsMax()){
                // ecrire qlq chose
            }

        }
    }

}
