package be.dungeon_ucm.demo.DAL.Models.Save;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Salle {
    @Id
    @Column(name = "Salle_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "Salle_IDDonjon")
    private Long IDDonjon;
    @Column(name = "Salle_posy")
    private int posy;
    @Column(name = "Salle_posx")
    private int posx;
    @Column(name = "Salle_type")
    private String type;
}
