package be.dungeon_ucm.demo.DAL.Models.Save;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Equipe {

    @Id
    @Column(name = "Equipe_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "Equipe_IDDonjon")
    private Long IDDonjon;
    @Column(name = "Equip_heroesList")
    @OneToMany(targetEntity = Heroes.class)
    private List<Heroes> heroesList;
}
