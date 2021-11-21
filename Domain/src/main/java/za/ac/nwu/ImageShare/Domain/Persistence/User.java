package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User implements Serializable{
    private UUID ID;
    private String userName;
    private String password;
    private String email;
    private boolean isActive;
    private Set<Image> images;

    public User() {
    }

    public User(UUID ID, String userName, String password, String email, boolean isActive, Set<Image> images) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.images = images;
    }

    public User(String userName, String password, String email, boolean isActive, Set<Image> images) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.images = images;
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

    @OneToMany(targetEntity = Image.class, fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.PERSIST)
    public Set<Image> getImages() {
        return images;
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

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive && Objects.equals(ID, user.ID) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(images, user.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userName, password, email, isActive, images);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", images=" + images +
                '}';
    }
}
