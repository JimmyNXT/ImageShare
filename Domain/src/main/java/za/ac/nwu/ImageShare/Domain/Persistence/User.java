package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User implements Serializable{
    private UUID ID;
    private String userName;
    private String password;
    private boolean isActive;
    private String role;


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

    @Column(name = "IS_ACTIVE")
    public boolean isActive() {
        return this.isActive;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return this.role;
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
