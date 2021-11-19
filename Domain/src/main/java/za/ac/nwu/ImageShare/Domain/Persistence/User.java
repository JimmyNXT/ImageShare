package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User implements Serializable{
    private UUID ID;
    private String userName;
    private String password;
    private String email;
    private boolean isActive;

    public User() {
    }

    public User(UUID ID, String userName, String password, String email, boolean isActive) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
    }

    public User(String userName, String password, String email, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public UUID getID() {
        return this.ID;
    }

    @Column(name = "USERNAME"/*, unique=true*/)
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
}
