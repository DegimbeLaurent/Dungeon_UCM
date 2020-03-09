package be.dungeon_ucm.demo.Outils.Factory.Steps;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import be.dungeon_ucm.demo.BL.Models.Personnage.Monstre.Monstre;
import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import be.dungeon_ucm.demo.BL.Services.ServiceImpl.PersonnageServiceImpl;
import be.dungeon_ucm.demo.Outils.Factory.Generateur.MonstreGener;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JeCréeDesMonstreSteps {

    private int degat;
    private int lvlDonjon;

    private Monstre monstre;
    private Monstre[] monstres;

    @Autowired
    private MonstreGener monstreGenerateur;
    @Autowired
    private PersonnageServiceImpl personnageService;


    @Given("je veux un monstre de type FEU de niveau {int}")
    public void donne_un_monstre(Integer lvlDonjon){
        this.lvlDonjon=lvlDonjon;
        this.monstre = monstreGenerateur.getMonstre(NatureElement.FEU,lvlDonjon);
    }

    @When("il subit des degat de {int}")
    public void infliger_degat_monstre(Integer degat){
        this.degat=degat;
        personnageService.subirDegatPhys(monstre,this.degat);
    }

    @Then("les PV du monstre ont reduit")
    public void pv_du_monstre_sont(){
        Assert.assertEquals(monstre.getPointDeVie(),(monstre.getPointDeVieMax()-degat));
        Assert.assertEquals(monstre.getNiveau(),this.lvlDonjon);
    }


}
