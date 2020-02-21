package be.dungeon_ucm.demo.API.DTO.Items.Recup;

import be.dungeon_ucm.demo.API.DTO.Items.ConsommableDTO;
import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Recup.ObjectRecupStat;

public class ObjectRecupStatDTO extends ConsommableDTO {
    private String stat;
    private int regenerationStat;

    public ObjectRecupStatDTO(ObjectRecupStat objectRecupStat){
        super(objectRecupStat);
        this.stat=objectRecupStat.getStat();
        this.regenerationStat=objectRecupStat.getRegenerationStat();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getRegenerationStat() {
        return regenerationStat;
    }

    public void setRegenerationStat(int regenerationStat) {
        this.regenerationStat = regenerationStat;
    }
}
