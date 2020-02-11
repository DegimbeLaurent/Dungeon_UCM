package be.dungeon_ucm.demo.API.DTO;

import be.dungeon_ucm.demo.DAL.Models.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDTO {

    private Integer id;
    private String nom;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nom = user.getNom();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
