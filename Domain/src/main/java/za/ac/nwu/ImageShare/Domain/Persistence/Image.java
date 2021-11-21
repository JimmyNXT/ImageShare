package za.ac.nwu.ImageShare.Domain.Persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "IMAGE")
public class Image implements Serializable {
    private UUID ID;
    private String file;
    private String filename;
    private FileExtension fileExtension;
    private User owner;
    private String geolocation;
    private Set<Tag> tags;
    private LocalDate captureDate;
    private String captureAuthor;
    private ZonedDateTime dateTimeAdded;

    public Image() {
    }

    public Image(UUID ID, String file, String filename, FileExtension fileExtension, User owner, String geolocation, Set<Tag> tags, LocalDate captureDate, String captureAuthor, ZonedDateTime dateTimeAdded) {
        this.ID = ID;
        this.file = file;
        this.filename = filename;
        this.fileExtension = fileExtension;
        this.owner = owner;
        this.geolocation = geolocation;
        this.tags = tags;
        this.captureDate = captureDate;
        this.captureAuthor = captureAuthor;
        this.dateTimeAdded = dateTimeAdded;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public UUID getID() {
        return this.ID;
    }

    @Column(name = "FILE")
    public String getFile() {
        return file;
    }

    @Column(name = "FILENAME")
    public String getFilename() {
        return filename;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_EXTENTION_ID")
    public FileExtension getFileExtension() {
        return fileExtension;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "OWNER_ID")
    public User getOwner() {
        return owner;
    }

    @Column(name = "GEOLOCATION")
    public String getGeolocation() {
        return geolocation;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "IMAGE_TAG",
            joinColumns = {
                    @JoinColumn(name = "IMAGE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "TAG_ID")
            }
    )
    public Set<Tag> getTags() {
        return tags;
    }

    @Column(name = "CAPTURE_DATE")
    public LocalDate getCaptureDate() {
        return captureDate;
    }

    @Column(name = "CAPTURE_AUTHER")
    public String getCaptureAuthor() {
        return captureAuthor;
    }

    @Column(name = "DATE_ADDED")
    public ZonedDateTime getDateTimeAdded() {
        return dateTimeAdded;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFileExtension(FileExtension fileExtention) {
        this.fileExtension = fileExtention;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public void setTags(Set<Tag> Tags) {
        this.tags = Tags;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    public void setCaptureAuthor(String captureAuthor) {
        this.captureAuthor = captureAuthor;
    }

    public void setDateTimeAdded(ZonedDateTime dateTimeAdded) {
        this.dateTimeAdded = dateTimeAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(ID, image.ID) && Objects.equals(file, image.file) && Objects.equals(filename, image.filename) && Objects.equals(fileExtension, image.fileExtension) && Objects.equals(owner, image.owner) && Objects.equals(geolocation, image.geolocation) && Objects.equals(tags, image.tags) && Objects.equals(captureDate, image.captureDate) && Objects.equals(captureAuthor, image.captureAuthor) && Objects.equals(dateTimeAdded, image.dateTimeAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, file, filename, fileExtension, owner, geolocation, tags, captureDate, captureAuthor, dateTimeAdded);
    }

    @Override
    public String toString() {
        return "Image{" +
                "ID=" + ID +
                ", file='" + file + '\'' +
                ", filename='" + filename + '\'' +
                ", FileExtension=" + fileExtension +
                ", owner=" + owner +
                ", geolocation='" + geolocation + '\'' +
                ", Tags=" + tags +
                ", captureDate=" + captureDate +
                ", captureAuthor='" + captureAuthor + '\'' +
                ", dateTimeAdded=" + dateTimeAdded +
                '}';
    }
}