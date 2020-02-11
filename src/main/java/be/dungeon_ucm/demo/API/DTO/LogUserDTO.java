package be.dungeon_ucm.demo.API.DTO;

public class LogUserDTO {

    private String pseudo;
    private String mdp;

    public LogUserDTO() {
    }

    public LogUserDTO(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
