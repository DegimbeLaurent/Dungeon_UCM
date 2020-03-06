package be.dungeon_ucm.demo.API.Controllers.DonjonController;


import be.dungeon_ucm.demo.API.DTO.donjonDTO.DonjonConstructorDTO;
import be.dungeon_ucm.demo.API.DTO.donjonDTO.DonjonDTO;
import be.dungeon_ucm.demo.API.DTO.donjonDTO.EquipeDTO;
import be.dungeon_ucm.demo.BL.Models.Donjons.Donjon;
import be.dungeon_ucm.demo.BL.Models.Donjons.Salle;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Services.DonjonGestion.LanceDonjon;
import be.dungeon_ucm.demo.BL.Services.DonjonGestion.MoveInDonjon;
import be.dungeon_ucm.demo.DAL.Models.Save.Equipe;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.DonjonGener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donjon")
@CrossOrigin
public class DonjonController {

    private LanceDonjon creationDonjon;
    private MoveInDonjon deplacement;
    private DonjonGener generer;
    private DonjonDTO donjonDTO;

    @Autowired
    public DonjonController(LanceDonjon creationDonjon, MoveInDonjon deplacement, DonjonGener generer, DonjonDTO donjonDTO){
        this.creationDonjon = creationDonjon;
        this.deplacement = deplacement;
        this.generer = generer;
        this.donjonDTO = donjonDTO;
    }

    // On recoit un niveau et un typeDeDonjon ainsi que Id
    @PostMapping("/creation/donjonSalle")
    public DonjonDTO postDonjon(@RequestBody DonjonConstructorDTO constructorDTO){
        Donjon dj = generer.creationDeDonjon(constructorDTO.getId(),constructorDTO.getNiveau(),constructorDTO.getType());
        Salle s = dj.getSalles().get(1);
        this.donjonDTO.setDonjon(dj);
        this.donjonDTO.setSalle(s);
        return new DonjonDTO(dj,s);
    }

    // renvoie le nouveau donjon et Envoyer à la vue
    @GetMapping("/pageAccueil")
    public DonjonDTO getDonjon(){
       return this.donjonDTO;
    }

    // deplacement effectuee
    @PostMapping("/move")
    public DonjonDTO postDeplacement(@RequestBody DonjonDTO donjonDTO){
        // On a besoin de savoir ou est la salle puis on regarde si il y a des salle a cote ...
        // On prend la salle couloir qui mene a une liste de salle qui vont mene au interface correspondant a leur type
        return donjonDTO;
    }

    // Methode de renvoie d'hero pour créer une équipe
    @PostMapping("/creation/equipe/Add")
    public Equipe postHeroEquipeAjouter(@RequestBody EquipeDTO equipeDTO){
        // On peut ajouter un personnage

        Equipe equipe = null;
        return equipe;
    }

    @PostMapping("/creation/equipe/delete")
    public Equipe postHeroEquipeSupprimer(@RequestBody EquipeDTO equipeDTO){
        // On peut enlever un personnage

        Equipe equipe = null;
        return equipe;
    }

}
