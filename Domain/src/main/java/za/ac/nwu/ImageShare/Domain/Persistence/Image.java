package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;
    private String Name;


}
