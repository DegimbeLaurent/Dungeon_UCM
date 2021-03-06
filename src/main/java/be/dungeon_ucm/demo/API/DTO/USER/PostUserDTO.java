package be.dungeon_ucm.demo.API.DTO.USER;

import be.dungeon_ucm.demo.DAL.Models.User;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

public class PostUserDTO {

    private Integer id;
    private String nom;
    @NotNull
    @Size(min = 6, max = 50)
    private String mdp;
    @UniqueElements
    @NotNull
    @Size(min = 6, max = 50)
    private String pseudo;

    public PostUserDTO() {}

    public User toEntity(){
        User user = new User();
        user.setNom(this.nom);
        user.setMdp(this.mdp);
        user.setPseudo(this.pseudo);
        return user;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

}
