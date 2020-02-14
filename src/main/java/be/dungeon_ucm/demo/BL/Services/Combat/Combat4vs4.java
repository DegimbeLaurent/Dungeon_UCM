package be.dungeon_ucm.demo.BL.Services.Combat;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.ServiceImpl.PersonnageServiceImpl;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Combat4vs4 {
    private MonstreGener gener;


    private Equipe[] groupe = new Equipe[2];
    private PersonnageServiceImpl personnageService;

    @Autowired
    public Combat4vs4(be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener gener,PersonnageServiceImpl personnageService) {
        this.gener = gener;
        this.personnageService = personnageService;
    }

    public Boolean combat(Equipe joureurs, NatureElement typeDonjon, int lvl){
        MonstreGener monstreGener = new MonstreGener();
        groupe[0] = joureurs;
        groupe[1] = monstreGener.DesMonstre(typeDonjon,lvl,4);
        Personnage[] ordrePer = ordrePassage(groupe);
        while ((groupe[0].getVivants() && groupe[1].getVivants()) || groupe[0].getFuir()){
            for (Personnage personnage:ordrePer) {
                if(personnage.getClass()==Monstre.class){

                }
                if(personnage.getClass()== Hero.class){
                }
            }
        }
        return true;
    }

    private Set<Long> ordrePassage(Equipe[] groupe){
        Personnage[] TabTrierPersonnage = new Personnage[(groupe[0].getEquipe().length+groupe[1].getEquipe().length)];
        System.arraycopy(groupe[0].getEquipe(),0,TabTrierPersonnage,0,groupe[0].getEquipe().length);
        System.arraycopy(groupe[1].getEquipe(),0,TabTrierPersonnage,groupe[0].getEquipe().length,groupe[1].getEquipe().length);
        Set<Long> idperso = new HashSet<>();
        for (int i = 0; i < TabTrierPersonnage.length; i++) {
            Personnage save;
            for (int j=TabTrierPersonnage.length-1; j > i; j--) {
                save = TabTrierPersonnage[i];
                if (save.getPointDeAgilite()<TabTrierPersonnage[j].getPointDeAgilite()){
                    TabTrierPersonnage[i] = TabTrierPersonnage[j];
                    TabTrierPersonnage[j] = save;
                }
            }
        }
        for (Personnage personnage: TabTrierPersonnage) {
            idperso.add(personnage.getId());
        }
        return idperso;
    }

    private Set<Personnage> frapper(Personnage[] personnagetab,Integer cap){
        personnageService.subirDegat();
    }

}
