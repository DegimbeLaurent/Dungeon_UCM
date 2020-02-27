package be.dungeon_ucm.demo.BL.Services.Combat;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjectRecupStat;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjetSoin;
import be.dungeon_ucm.demo.BL.Models.Items.ItemBasique;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.ServiceImpl.PersonnageServiceImpl;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.cert.CertificateRevokedException;
import java.util.HashSet;
import java.util.Set;

@Component
public class Combat4vs4<S> {
    private MonstreGener gener;

    private Equipe[] groupe = new Equipe[2];
    private PersonnageServiceImpl personnageService;

    @Autowired
    public Combat4vs4(be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener gener, PersonnageServiceImpl personnageService) {
        this.gener = gener;
        this.personnageService = personnageService;
    }

    public Personnage UseObjet(Personnage personnage, Consommable popo) {
        if (popo instanceof ObjetSoin) {
            personnageService.recupererPv(personnage, ((ObjetSoin) popo).getPointDeSoin());
        } else if (popo instanceof ObjectRecupStat) {
            personnageService.modifierEtat(personnage, Etat.NORMAL);
        } else {
            System.out.println(-42);
        }
        return personnage;
    }

    public Long[] ordrePassage(Personnage[] hero, Personnage[] monstre) {
        Personnage[] TabTrierPersonnage = new Personnage[(hero.length + monstre.length)];
        System.arraycopy(hero, 0, TabTrierPersonnage, 0, hero.length);
        System.arraycopy(monstre, 0, TabTrierPersonnage, hero.length, monstre.length);
        Long[] idperso = new Long[TabTrierPersonnage.length];
        for (int i = 0; i < TabTrierPersonnage.length; i++) {
            Personnage save;
            for (int j = TabTrierPersonnage.length - 1; j > i; j--) {
                save = TabTrierPersonnage[i];
                if (save.getPointDeAgilite() < TabTrierPersonnage[j].getPointDeAgilite()) {
                    TabTrierPersonnage[i] = TabTrierPersonnage[j];
                    TabTrierPersonnage[j] = save;
                }
            }
        }
        for (int i = 0; i < TabTrierPersonnage.length; i++) {
            idperso[i] = TabTrierPersonnage[i].getId();
        }
        return idperso;
    }

    public void frapper(Personnage attaquant,Personnage defenseur, int cap) {
        if (attaquant.getCapacites().get(cap).isGenreMagic()) {
            personnageService.subirDegatMagic(
                    defenseur,
                    (attaquant.getPointDeIntelligence() + attaquant.getCapacites().get(cap).getDegats())
            );
            if (gener.rand(100) <= attaquant.getCapacites().get(cap).getCoupCritique()) {
                personnageService.modifierEtat(
                        defenseur,
                        attaquant.getCapacites().get(cap).getEffectCritique() // ????????????????????? fk
                );
            }
            System.out.println(defenseur.getPointDeVie());
        } else {
            personnageService.subirDegatPhys(
                    defenseur,
                    (attaquant.getPointDeForce() + attaquant.getCapacites().get(cap).getDegats())
            );
            if (gener.rand(100) <= attaquant.getCapacites().get(cap).getCoupCritique()) {
                personnageService.modifierEtat(
                        defenseur,
                        attaquant.getCapacites().get(cap).getEffectCritique()
                );
            }
            System.out.println(defenseur.getPointDeVie());
        }

    }

}
