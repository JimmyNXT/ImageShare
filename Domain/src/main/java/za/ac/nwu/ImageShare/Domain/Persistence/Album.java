package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {

    private UUID ID;
    private String name;
    private User owner;
    private Set<Image> imageSet;
    private Set<User> sharedWithUsers;

    public Album() {
    }

    public Album(String name, User owner, Set<Image> imageSet, Set<User> sharedWithUsers) {
        this.name = name;
        this.owner = owner;
        this.imageSet = imageSet;
        this.sharedWithUsers = sharedWithUsers;
    }

    public Album(UUID ID, String name, User owner, Set<Image> imageSet, Set<User> sharedWithUsers) {
        this.ID = ID;
        this.name = name;
        this.owner = owner;
        this.imageSet = imageSet;
        this.sharedWithUsers = sharedWithUsers;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public UUID getID() {
        return ID;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "OWNER_ID")
    public User getOwner() {
        return owner;
    }

    @OneToMany(targetEntity = Image.class, fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.PERSIST)
    public Set<Image> getImageSet() {
        return imageSet;
    }

    @ManyToMany(mappedBy = "albumsSharedWithUser", cascade = CascadeType.PERSIST)
    public Set<User> getSharedWithUsers() {
        return sharedWithUsers;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
    }

    public void setSharedWithUsers(Set<User> sharedWithUsers) {
        this.sharedWithUsers = sharedWithUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(ID, album.ID) && Objects.equals(name, album.name) && Objects.equals(owner, album.owner) && Objects.equals(imageSet, album.imageSet) && Objects.equals(sharedWithUsers, album.sharedWithUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, owner, imageSet, sharedWithUsers);
    }

    @Override
    public String toString() {
        return "Album{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", imageSet=" + imageSet +
                ", sharedWithUsers=" + sharedWithUsers +
                '}';
    }
}
