package be.dungeon_ucm.demo.API.Controllers.DonjonController;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Services.DonjonGestion.LanceDonjon;
import be.dungeon_ucm.demo.BL.Services.DonjonGestion.MoveInDonjon;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.DonjonGener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ParameterDonjonController {

    private LanceDonjon creationDonjon;
    private MoveInDonjon deplacement;
    private DonjonGener generer;

    @Autowired
    public ParameterDonjonController(LanceDonjon creationDonjon, MoveInDonjon deplacement, DonjonGener generer){
        this.creationDonjon = creationDonjon;
        this.deplacement = deplacement;
        this.generer = generer;
    }

    // Envoie la liste des types de donjon possible
    @GetMapping("/combat/listElement")
    public List<String> getListElement(){
        List<String> types = new ArrayList<>();
        for (NatureElement a: NatureElement.values()) {
            types.add(a.name());
        }
        return types;
    }
}
