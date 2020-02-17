package be.dungeon_ucm.demo.API.Controllers.Combat;

import be.dungeon_ucm.demo.API.DTO.Combat.CombatStarDTO;
import be.dungeon_ucm.demo.API.DTO.Combat.CombatTourDTO;
import be.dungeon_ucm.demo.BL.Services.Combat.Combat4vs4;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
