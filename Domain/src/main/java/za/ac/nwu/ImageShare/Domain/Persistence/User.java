package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    private UUID ID;
    private String userName;
    private String password;
    private String email;
    private boolean isActive;
    private Set<Album> albums;
    private Set<Album> albumsSharedWithUser;
    private Set<Image> imagesSharedWithUser;

    public User() {
    }

    public User(UUID ID, String userName, String password, String email, boolean isActive, Set<Album> albums, Set<Album> albumsSharedWithUser, Set<Image> imagesSharedWithUser) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.albums = albums;
        this.albumsSharedWithUser = albumsSharedWithUser;
        this.imagesSharedWithUser = imagesSharedWithUser;
    }

    public User(String userName, String password, String email, boolean isActive, Set<Album> albums, Set<Album> albumsSharedWithUser, Set<Image> imagesSharedWithUser) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.albums = albums;
        this.albumsSharedWithUser = albumsSharedWithUser;
        this.imagesSharedWithUser = imagesSharedWithUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public UUID getID() {
        return this.ID;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return this.userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return this.password;
    }

    @Column(name = "EMAIL", unique = true)
    public String getEmail() {
        return email;
    }

    @Column(name = "IS_ACTIVE")
    public boolean isActive() {
        return this.isActive;
    }

    @OneToMany(targetEntity = Album.class, fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.PERSIST)
    public Set<Album> getAlbums() {
        return albums;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "USER_ALBUM_SHARED_WITH_USER",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ALBUM_ID")
            }
    )
    public Set<Album> getAlbumsSharedWithUser() {
        return albumsSharedWithUser;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "USER_IMAGES_SHARED_WITH_USER",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Image_ID")
            }
    )
    public Set<Image> getImagesSharedWithUser() {
        return imagesSharedWithUser;
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

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void setAlbumsSharedWithUser(Set<Album> albumsSharedWithUser) {
        this.albumsSharedWithUser = albumsSharedWithUser;
    }

    public void setImagesSharedWithUser(Set<Image> imagesSharedWithUser) {
        this.imagesSharedWithUser = imagesSharedWithUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive && Objects.equals(ID, user.ID) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(albums, user.albums) && Objects.equals(albumsSharedWithUser, user.albumsSharedWithUser) && Objects.equals(imagesSharedWithUser, user.imagesSharedWithUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userName, password, email, isActive, albums, albumsSharedWithUser, imagesSharedWithUser);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", albums=" + albums +
                ", albumsSharedWithUser=" + albumsSharedWithUser +
                ", imagesSharedWithUser=" + imagesSharedWithUser +
                '}';
    }
}
