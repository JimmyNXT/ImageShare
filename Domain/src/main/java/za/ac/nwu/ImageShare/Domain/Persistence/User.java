package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User implements Serializable{
    private UUID ID;
    private String userName;
    private String password;
    private String email;
    private boolean isActive;
    private List<Role> roles;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public UUID getID() {
        return this.ID;
    }

    @Column(name = "USERNAME", unique=true)
    public String getUserName() {
        return this.userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return this.password;
    }
    @Column(name = "EMAIL", unique=true)
    public String getEmail() {
        return email;
    }

    @Column(name = "IS_ACTIVE")
    public boolean isActive() {
        return this.isActive;
    }

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    public List<Role> getRoles() {
        return roles;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
