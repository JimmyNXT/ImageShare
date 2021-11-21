package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FILE_EXTENSION")
public class FileExtension implements Serializable {
    private Integer ID;
    private String extension;
    private Set<Image> images;

    public FileExtension() {
    }

    public FileExtension(Integer ID, String extension, Set<Image> images) {
        this.ID = ID;
        this.extension = extension;
        this.images = images;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    @Column(name = "EXTENSION")
    public String getExtension() {
        return extension;
    }

    @OneToMany(targetEntity = Image.class, fetch = FetchType.LAZY, mappedBy = "fileExtension", cascade = CascadeType.PERSIST)
    public Set<Image> getImages() {
        return images;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileExtension that = (FileExtension) o;
        return ID == that.ID && Objects.equals(extension, that.extension) && Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, extension, images);
    }

    @Override
    public String toString() {
        return "FileExtension{" +
                "ID=" + ID +
                ", extension='" + extension + '\'' +
                ", images=" + images +
                '}';
    }
}
