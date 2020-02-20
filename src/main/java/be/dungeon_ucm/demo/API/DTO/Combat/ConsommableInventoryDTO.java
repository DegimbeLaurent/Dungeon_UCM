package be.dungeon_ucm.demo.API.DTO.Combat;

import be.dungeon_ucm.demo.API.DTO.Items.ConsommableDTO;
import be.dungeon_ucm.demo.BL.Models.Combat.ConsommableInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsommableInventoryDTO {

    private List<ConsommableDTO> consommables=new ArrayList<>();

    public ConsommableInventoryDTO(ConsommableInventory consommableInventory){
        this.consommables=consommableInventory.getConsommables().stream().map(
                ConsommableDTO::new
        ).collect(Collectors.toList());
    }

    public List<ConsommableDTO> getConsommables() {
        return consommables;
    }

    public void setConsommables(List<ConsommableDTO> consommables) {
        this.consommables = consommables;
    }
}
