package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TAG")
public class Tag implements Serializable {
    private Integer ID;
    private String tagName;
    private Set<Image> images;

    public Tag(Integer ID, String tagName, Set<Image> images) {
        this.ID = ID;
        this.tagName = tagName;
        this.images = images;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    @Column(name = "TAG_NAME")
    public String getTagName() {
        return tagName;
    }

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    public Set<Image> getImages() {
        return images;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return ID == tag.ID && Objects.equals(tagName, tag.tagName) && Objects.equals(images, tag.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, tagName, images);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "ID=" + ID +
                ", tagName='" + tagName + '\'' +
                ", images=" + images +
                '}';
    }
}
