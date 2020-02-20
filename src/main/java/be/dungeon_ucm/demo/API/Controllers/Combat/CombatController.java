package be.dungeon_ucm.demo.API.Controllers.Combat;

import be.dungeon_ucm.demo.API.DTO.Combat.CombatStarDTO;
import be.dungeon_ucm.demo.API.DTO.Combat.CombatTourDTO;
import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Services.Combat.Combat4vs4;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;
import be.dungeon_ucm.demo.Outils.Services.GenerateurIDpersonnageServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/combat")
@CrossOrigin
public class CombatController {

    private MonstreGener monstreGener;
    private Combat4vs4 combat4vs4;
    private GenerateurIDpersonnageServicelmpl generateurIDpersonnageServicelmpl;

    @Autowired
    public CombatController(MonstreGener monstreGener, Combat4vs4 combat4vs4, GenerateurIDpersonnageServicelmpl generateurIDpersonnageServicelmpl) {
        this.monstreGener = monstreGener;
        this.combat4vs4 = combat4vs4;
        this.generateurIDpersonnageServicelmpl = generateurIDpersonnageServicelmpl;
    }

    @GetMapping("/getlancer")
    public CombatStarDTO getAll(){
        Hero jou1 = new Hero("PersoTest1",20,10,3,4,3,5,5,8);
        Hero jou2 = new Hero("PersoTest2",20,10,3,3,3,5,5,8);
        Hero jou3 = new Hero("PersoTest3",20,10,3,5,3,5,5,8);
        Hero jou4 = new Hero("PersoTest4",20,10,3,2,3,5,5,8);
        Capacite capacite1 = new Capacite("boule de feu",6,10,1,false,1,true,Etat.BRULEE, NatureElement.FEU);
        Capacite capacite2 = new Capacite("boule de glace",6,10,1,false,1,true,Etat.GELE, NatureElement.GLACE);
        Capacite capacite3 = new Capacite("coup de pied",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        Capacite capacite4 = new Capacite("coup de tête",6,10,1,false,1,false,Etat.NORMAL, NatureElement.NEUTRE);
        Hero[] a = new Hero[4];
        jou1.setId(generateurIDpersonnageServicelmpl.getIDNEXT());
        jou2.setId(generateurIDpersonnageServicelmpl.getIDNEXT());
        jou3.setId(generateurIDpersonnageServicelmpl.getIDNEXT());
        jou4.setId(generateurIDpersonnageServicelmpl.getIDNEXT());
        a[0] = jou1;
        a[1] = jou2;
        a[2] = jou3;
        a[3] = jou4;
        List<Capacite> capacites = new ArrayList<Capacite>();
        capacites.add(capacite1);
        capacites.add(capacite2);
        capacites.add(capacite3);
        capacites.add(capacite4);
        for (Hero perso:a) {
            perso.setCapacites(capacites);
        }
        return new CombatStarDTO(a,"FEU",1);
    }

    @PostMapping("/lancer")
    public CombatStarDTO lancer(@RequestBody CombatStarDTO combatStarDTO){
        System.out.println("coucou.txt");
        System.out.println(combatStarDTO);
        if(combatStarDTO.getJoueurs() == null){
            combatStarDTO = getAll();
        }
        combatStarDTO.setMonstre(monstreGener.DesMonstre(NatureElement.valueOf(combatStarDTO.getTypeDonjon()), combatStarDTO.getLvlDonjon(),4));
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
