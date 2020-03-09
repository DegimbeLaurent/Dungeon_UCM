package be.dungeon_ucm.demo.API.Controllers.Combat;

import be.dungeon_ucm.demo.API.DTO.Combat.CombatStarDTO;
import be.dungeon_ucm.demo.API.DTO.Combat.CombatTourDTO;
import be.dungeon_ucm.demo.API.DTO.Combat.ConsommableInventoryDTO;
import be.dungeon_ucm.demo.BL.Models.Combat.ConsommableInventory;
import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Boost.ObjectBoost;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjectRecupStat;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjetSoin;
import be.dungeon_ucm.demo.BL.Models.Personnage.Capacite;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
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
        Capacite capacite1 = new Capacite("boule de feu",6,10,1,false,3,true,Etat.BRULEE, NatureElement.FEU);
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
    public CombatStarDTO choix(@RequestBody CombatStarDTO combatStarDTO){
        System.out.println(combatStarDTO.getMonstreattaquant());
        switch (combatStarDTO.getChoix()){
            case 1:
                if(combatStarDTO.getHeroesattaquant()!=null) {
                    if (combatStarDTO.getHeroesattaquant().getNomPersonnage() != null) {
                        for (int cible: combatStarDTO.getCible()) {
                            combat4vs4.frapper(combatStarDTO.getHeroesattaquant(),combatStarDTO.getMonstre()[cible],combatStarDTO.getCap());
                        }
                    }
                }
                if(combatStarDTO.getMonstreattaquant()!=null) {
                    if (combatStarDTO.getMonstreattaquant().getNomPersonnage() != null) {
                        for (int cible: combatStarDTO.getCible()) {
                            combat4vs4.frapper(combatStarDTO.getMonstreattaquant(),combatStarDTO.getJoueurs()[cible],combatStarDTO.getCap());
                        }
                    }
                }

                break;
            case 2:

                break;
        }
        for (Hero hero:combatStarDTO.getJoueurs()) {
            System.out.println(hero.getPointDeVie());
        }
        return combatStarDTO;
    }

    @GetMapping("/inventaireConsommables")
    public ConsommableInventoryDTO getInventaireConsommables(){
        //todo : remplacer déclaration par un appel service
        ConsommableInventory inventory=new ConsommableInventory();
        List<Consommable> consommables=inventory.getConsommables();
        Consommable c1=new Consommable("bouteille de vin");
        c1.setId(1);
        Consommable c2=new ObjetSoin("potion de vie",15);
        c2.setId(2);
        Consommable c3=new ObjectRecupStat("elixir d'endurance","endurance",20);
        c3.setId(3);
        Consommable c4=new ObjectBoost("potion de forte endurance","booste votre endurance",4,"endurance");
        c4.setId(4);

        consommables.add(c1);
        consommables.add(c2);
        consommables.add(c3);
        consommables.add(c4);

        return new ConsommableInventoryDTO(inventory);
    }

    @PostMapping("/utiliserConsommable")
    public void utiliserConsommable(int consommableId,int HeroId){
        //todo : implementer
    }
}
