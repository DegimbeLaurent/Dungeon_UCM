package be.dungeon_ucm.demo.DAL.Models.Data;


import be.dungeon_ucm.demo.BL.Models.EtatNature.Etat;
import be.dungeon_ucm.demo.BL.Models.EtatNature.NatureElement;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Capacite_Liste")
public class CapaciteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,name = "Nom", nullable = false)
    private String nomCapacite;

    @Column(name="Degats",nullable = false)
    private int degats;

    @Column(name = "taux_Critique", nullable = false)
    private int tauxCritiqueCapacite;

    @Column(name = "Niveau_Requis", nullable = false)
    private int niveauUtilisation;

    @Column(name ="Type_Capacite", nullable = false)
    private boolean type;

    @Column(name ="forme_Capacite", nullable = false)
    private boolean isMagique;

    @Column(name="Etat", nullable = false)
    private String etatNom;

    @Column(name="Nature", nullable = false)
    private String natureNom;


}
