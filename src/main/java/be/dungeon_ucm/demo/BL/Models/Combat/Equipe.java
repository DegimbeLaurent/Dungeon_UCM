package be.dungeon_ucm.demo.BL.Models.Combat;

import be.dungeon_ucm.demo.BL.Models.Personnage.Personnage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Equipe {

    private Personnage[] equipe;
    private Boolean vivants;
    private Boolean bot;
    private Boolean fuir;

    public Equipe(Boolean BotTorJoueurF,Personnage... personnages) {
        this.vivants = true;
        this.bot = BotTorJoueurF;
        for (int i = 0; i <personnages.length ; i++) {
            equipe[i]=personnages[i];
        }
        this.fuir= false;
    }
    public void setVivants() {
        int compt=0;
        for (Personnage perso: equipe) {
            if(perso.getVie()==false){
                compt++;
            }
        }
        if (compt==equipe.length){
            this.vivants=false;
        }
    }

    public void setBot() {}
}
