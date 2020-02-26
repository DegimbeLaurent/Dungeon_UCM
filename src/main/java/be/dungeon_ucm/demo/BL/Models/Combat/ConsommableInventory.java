package be.dungeon_ucm.demo.BL.Models.Combat;

import be.dungeon_ucm.demo.BL.Models.Items.Consommable.Consommable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * représente l'ensemble des consommables disponibles
 * pour le joueur en combat
 */
public class ConsommableInventory {
    private List<Consommable> consommables;

    public ConsommableInventory() {
        this.consommables=new ArrayList<>();
    }

    public void ajouterConsommable(Consommable consommable){
        this.consommables.add(consommable);
    }

    public void ajouterConsommables(Consommable ...consommables){
        this.consommables.addAll(Arrays.asList(consommables));
    }

    public void retirerConsommableParId(int id){
        this.consommables=this.consommables.stream().filter(consommable->consommable.getId()!=id).collect(Collectors.toList());
    }

    public List<Consommable> getConsommables() {
        return consommables;
    }

    public void setConsommables(List<Consommable> consommables) {
        this.consommables = consommables;
    }
}
