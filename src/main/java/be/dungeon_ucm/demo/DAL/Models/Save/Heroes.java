package be.dungeon_ucm.demo.DAL.Models.Save;

import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.Personnage.Corps;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Heroes {

    @Id
    @Column(name = "Heroe_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "Heroe_IDSave", nullable = false)
    private Long IDSave;
    @Column(name = "Heroe_nomPersonnage", nullable = false)
    private String nomPersonnage;
    @Column(name = "Heroe_pointDeForce", nullable = false)
    private int pointDeForce;
    @Column(name = "Heroe_pointDeIntelligence", nullable = false)
    private int pointDeIntelligence;
    @Column(name = "Heroe_pointDeAgilite", nullable = false)
    private int pointDeAgilite;
    @Column(name = "Heroe_pointDeCharisme", nullable = false)
    private int pointDeCharisme;
    @Column(name = "Heroe_pointDeResistancePhysique", nullable = false)
    private int pointDeResistancePhysique;
    @Column(name = "Heroe_pointDeResistanceMagique", nullable = false)
    private int pointDeResistanceMagique;
    @Column(name = "Heroe_pointDeVieMax", nullable = false)
    private int pointDeVieMax;
    @Column(name = "Heroe_pointDeManaMax", nullable = false)
    private int pointDeManaMax;
    @Column(name = "Heroe_niveau", nullable = false)
    private int niveau;
}
