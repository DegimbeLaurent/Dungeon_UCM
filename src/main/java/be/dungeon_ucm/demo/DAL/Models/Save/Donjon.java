package be.dungeon_ucm.demo.DAL.Models.Save;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Donjon {

    @Id
    @Column(name = "Donjon_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @ManyToOne(targetEntity = Save.class)
    @Column(name = "Donjon_IDSave", nullable = false)
    private Long IDSave;
    @Column(name = "Donjon_type", nullable = false)
    private String type;
    @Column(name = "Donjon_lvl", nullable = false)
    private int lvl;


}
