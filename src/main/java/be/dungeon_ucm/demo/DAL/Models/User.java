package be.dungeon_ucm.demo.DAL.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Game_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_nom")
    private String nom;
    @Column(name = "user_mdp",nullable = false)
    private String mdp;
    @Column(name = "user_pseudo",unique = true,nullable = false)
    private String pseudo;
}
