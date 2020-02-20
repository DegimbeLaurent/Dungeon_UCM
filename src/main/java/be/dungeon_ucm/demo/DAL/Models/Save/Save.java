package be.dungeon_ucm.demo.DAL.Models.Save;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Save {

    @Id
    @Column(name = "Save_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "Save_IDUser", nullable = false)
    private Long IDUser;

    @OneToMany(targetEntity = Heroes.class)
    private Set<Heroes> heroesSet;

    @OneToOne
    private Donjon donjon;

}
