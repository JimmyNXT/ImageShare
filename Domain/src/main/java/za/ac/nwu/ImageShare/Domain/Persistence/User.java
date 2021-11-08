package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class User implements Serializable{
    private Integer ID;
    private String userName;
    private String password;
    private boolean isActive;
    private String role;


    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
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

    public void setID(Integer ID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID && isActive == user.isActive && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userName, password, isActive, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", role='" + role + '\'' +
                '}';
    }
}
