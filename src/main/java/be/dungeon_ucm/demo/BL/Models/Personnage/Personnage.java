package be.dungeon_ucm.demo.BL.Models.Personnage;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;


public class Personnage {

    private long id;
    private String nomPersonnage;
    private int pointDeVie;
    private int pointDeMana;
    private int pointDeForce;
    private int pointDeIntelligence;
    private int pointDeAgilite;
    private int pointDeCharisme;
    private int pointDeResistancePhysique;
    private int pointDeResistanceMagique;
    private int pointDeVieMax;
    private int pointDeManaMax;
    private Etat etat;
    private Boolean vie;
    private int niveau;

    public Personnage() {
    }
    public Personnage(String nomPersonnage, int pointDeVie, int pointDeMana, int pointDeForce, int pointDeAgilite,
                      int pointDeIntelligence, int pointDeCharisme){
        this.etat = Etat.NORMAL;
        this.vie = true;
        this.niveau = 1;
        this.nomPersonnage = nomPersonnage;
        this.pointDeVie = pointDeVie;
        this.pointDeMana = pointDeMana;
        this.pointDeForce = pointDeForce;
        this.pointDeAgilite = pointDeAgilite;
        this.pointDeIntelligence = pointDeIntelligence;
        this.pointDeCharisme = pointDeCharisme;
        this.pointDeResistancePhysique = 0;
        this.pointDeResistanceMagique = 0;
        this.pointDeVieMax = pointDeVie;
        this.pointDeManaMax = pointDeMana;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
            this.pointDeVie = pointDeVie;
            if(this.getPointDeVie() <= 0){
                setVie(false);
                setEtat(Etat.MORT);
            }
    }

    public int getPointDeMana() {
        return pointDeMana;
    }

    public void setPointDeMana(int pointDeMana) {
        this.pointDeMana = pointDeMana;
    }

    public int getPointDeForce() {
        return pointDeForce;
    }

    public void setPointDeForce(int pointDeForce) {
        this.pointDeForce = pointDeForce;
    }

    public int getPointDeIntelligence() {
        return pointDeIntelligence;
    }

    public void setPointDeIntelligence(int pointDeIntelligence) {
        this.pointDeIntelligence = pointDeIntelligence;
    }

    public int getPointDeAgilite() {
        return pointDeAgilite;
    }

    public void setPointDeAgilite(int pointDeAgilite) {
        this.pointDeAgilite = pointDeAgilite;
    }

    public int getPointDeCharisme() {
        return pointDeCharisme;
    }

    public void setPointDeCharisme(int pointDeCharisme) {
        this.pointDeCharisme = pointDeCharisme;
    }

    public int getPointDeResistancePhysique() {
        return pointDeResistancePhysique;
    }

    public void setPointDeResistancePhysique(int pointDeResistancePhysique) {
        this.pointDeResistancePhysique = pointDeResistancePhysique;
    }

    public int getPointDeResistanceMagique() {
        return pointDeResistanceMagique;
    }

    public void setPointDeResistanceMagique(int pointDeResistanceMagique) {
        this.pointDeResistanceMagique = pointDeResistanceMagique;
    }

    public int getPointDeVieMax() {
        return pointDeVieMax;
    }

    public void setPointDeVieMax(int pointDeVieMax) {
        this.pointDeVieMax = pointDeVieMax;
    }

    public int getPointDeManaMax() {
        return pointDeManaMax;
    }

    public void setPointDeManaMax(int pointDeManaMax) {
        this.pointDeManaMax = pointDeManaMax;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Boolean getVie() {
        return vie;
    }

    public void setVie(Boolean vie) {
        this.vie = vie;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
