package be.dungeon_ucm.demo.API.Controllers.Combat;

import be.dungeon_ucm.demo.API.DTO.Combat.CombatStarDTO;
import be.dungeon_ucm.demo.API.DTO.Combat.CombatTourDTO;
import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.Combat.Combat4vs4;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/combat")
@CrossOrigin
public class CombatController {

    private MonstreGener monstreGener;
    private Combat4vs4 combat4vs4;

    @Autowired
    public CombatController(MonstreGener monstreGener, Combat4vs4 combat4vs4) {
        this.monstreGener = monstreGener;
        this.combat4vs4 = combat4vs4;
    }

    @GetMapping("/getlancer")
    public CombatStarDTO getAll(){
        Personnage jou1 = new Personnage("PersoTest1",20,10,3,4,3,5);
        Personnage jou2 = new Personnage("PersoTest2",20,10,3,3,3,5);
        Personnage jou3 = new Personnage("PersoTest3",20,10,3,5,3,5);
        Personnage jou4 = new Personnage("PersoTest4",20,10,3,2,3,5);
        Capacite capacite1 = new Capacite("boule de feu",6,10,1,false,1,true,Etat.BRULEE, NatureElement.FEU);
        Capacite capacite2 = new Capacite("boule de glace",6,10,1,false,1,true,Etat.GELE, NatureElement.GLACE);
        Capacite capacite3 = new Capacite("coup de pied",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        Capacite capacite4 = new Capacite("coup de tête",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        Personnage[] a = new Personnage[4];
        a[0] = jou1;
        a[1] = jou2;
        a[2] = jou3;
        a[3] = jou4;
        List<Capacite> capacites = null;
        capacites.add(capacite1);
        capacites.add(capacite2);
        capacites.add(capacite3);
        capacites.add(capacite4);
        for (Personnage perso:a) {
            perso.setCapacites(capacites);
        }

        return new CombatStarDTO(a,NatureElement.FEU,1);
    }

    @PostMapping("/lancer")
    public CombatStarDTO lancer(@RequestBody @Valid CombatStarDTO combatStarDTO){
        combatStarDTO.setMonstre(monstreGener.DesMonstre(combatStarDTO.getTypeDonjon(), combatStarDTO.getLvlDonjon(),4));
        combatStarDTO.setOrdre(combat4vs4.ordrePassage(combatStarDTO.getJoueurs(), combatStarDTO.getMonstre()));
        return combatStarDTO;
    }


    @PostMapping("/choix")
    public CombatTourDTO choix(@RequestBody @Valid CombatTourDTO combatTourDTO){
        switch (combatTourDTO.getChoix()){
            case 1:
                combat4vs4.frapper(combatTourDTO.getPersonnages(),combatTourDTO.getCap());
                break;
            case 2:
                combat4vs4.UseObjet(combatTourDTO.getPersonnages()[1],combatTourDTO.getConsommable());
                break;
        }
        return combatTourDTO;
    }
}
