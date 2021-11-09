package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {
    private Integer ID;
    private String Name;

    public Role() {
    }

    public Role(Integer ID, String name) {
        this.ID = ID;
        Name = name;
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

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(ID, role.ID) && Objects.equals(Name, role.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
