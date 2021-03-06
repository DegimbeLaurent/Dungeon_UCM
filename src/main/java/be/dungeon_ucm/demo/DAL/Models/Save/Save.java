package be.dungeon_ucm.demo.DAL.Models.Save;

import lombok.*;

import javax.persistence.*;

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

}
