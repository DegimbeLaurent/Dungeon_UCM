package be.dungeon_ucm.demo.API.DTO.donjonDTO;

import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import org.hibernate.criterion.Junction;

public class DonjonConstructorDTO {

    private Long id;
    private NatureElement type;
    private int niveau;

    public DonjonConstructorDTO(Long id, NatureElement type, int niveau) {
        this.id = id;
        this.type = type;
        this.niveau = niveau;
    }

    public DonjonConstructorDTO(String name, int niveau) {
        this.type = NatureElement.NEUTRE;
        for (NatureElement a: NatureElement.values()) {
            if(a.name().equals(name)){
                this.type = a;
            }
        }
        this.niveau = niveau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NatureElement getType() {
        return type;
    }

    public void setType(NatureElement type) {
        this.type = type;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
