package be.dungeon_ucm.demo.API.DTO.donjonDTO;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;
import be.dungeon_ucm.demo.BL.Models.Personnage.Hero.Hero;

import java.util.List;

public class EquipeDTO {

    private List<Hero> heros;

    public EquipeDTO(List<Hero> heros){
        this.heros = heros;
    }

    public List<Hero> getHeros() {
        return heros;
    }

    public void setHeros(List<Hero> heros) {
        this.heros = heros;
    }
}
