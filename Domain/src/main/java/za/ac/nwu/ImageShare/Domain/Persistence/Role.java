package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {
    private Integer ID;
    private String Name;
    private String Description;
    private List<User> users;



    public Role() {
    }

    public Role(Integer ID, String name, String description, List<User> users) {
        this.ID = ID;
        this.Name = name;
        this.Description = description;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    @Column(name = "NAME", unique=true)
    public String getName() {
        return Name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return Description;
    }

    @ManyToMany(targetEntity = User.class, mappedBy = "roles", cascade = CascadeType.ALL)
    public List<User> getUsers() {
        return users;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
