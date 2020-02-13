package be.dungeon_ucm.demo.BL.Models.EtatNature;




public enum Etat {

    BRULEE("brûlé",2,"",false),
    CONSTIPER("a la chiasse",2,"",false),
    MORT("mort",2,"",false),
    REVENANT("mort-vivant",2,"",false),
    VIVANT("vivant",2,"",true),
    NORMAL("normal",2,"",true),
    INCONNU("situation inconnue",2,"",false),
    GELE("gelé",2,"",false);


    private String  nom;
    private int     influenceEtat;
    private String  label;
    private boolean influenceSort;

    Etat(String nom, int influenceEtat , String label, boolean influenceSort){
        this.influenceEtat = influenceEtat;
        this.label = label;
        this.nom = nom;
        this.influenceSort = influenceSort;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getInfluenceEtat() {
        return influenceEtat;
    }

    public void setInfluenceEtat(int influenceEtat) {
        this.influenceEtat = influenceEtat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isInfluenceSort() {
        return influenceSort;
    }

    public void setInfluenceSort(boolean influenceSort) {
        this.influenceSort = influenceSort;
    }
}
