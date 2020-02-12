package be.dungeon_ucm.demo.DAL.Models.Data;


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

    @Column(unique = true,name = "Nom")
    private String nomCapacite;

    @Column(name="Degats",nullable = false)
    private int degats;

    @Column(name = "taux_Critique")
    private int tauxCritiqueCapacite;

    @Column(name = "Niveau_Requis")
    private int niveauUtilisation;

    @Column(name ="Type_Capacite")
    private boolean type;

    @Column(name ="forme_Capacite")
    private boolean isMagique;

    @Column(name="ID_Etat")
    private int id_Etat;

    @Column(name="Id_Nature")
    private int id_Nature;
}
