package za.ac.nwu.ImageShare.Domain.DataTransfer;

import za.ac.nwu.ImageShare.Domain.Persistence.Album;
import za.ac.nwu.ImageShare.Domain.Persistence.FileExtension;
import za.ac.nwu.ImageShare.Domain.Persistence.Image;
import za.ac.nwu.ImageShare.Domain.Persistence.Tag;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class ImageDTO {
    private UUID ID;
    private String filename;
    private String fileExtension;
    private String album;
    private String geolocation;
    private String tags;
    private LocalDate captureDate;
    private String captureAuthor;

    public ImageDTO(UUID ID, String filename, String fileExtension, String album, String geolocation, String tags, LocalDate captureDate, String captureAuthor) {
        this.ID = ID;
        this.filename = filename;
        this.fileExtension = fileExtension;
        this.album = album;
        this.geolocation = geolocation;
        this.tags = tags;
        this.captureDate = captureDate;
        this.captureAuthor = captureAuthor;
    }

    public ImageDTO(String filename, String fileExtension, String album, String geolocation, String tags, LocalDate captureDate, String captureAuthor) {
        this.filename = filename;
        this.fileExtension = fileExtension;
        this.album = album;
        this.geolocation = geolocation;
        this.tags = tags;
        this.captureDate = captureDate;
        this.captureAuthor = captureAuthor;
    }

    public ImageDTO(Image image) {
        this.filename = image.getFilename();
        this.fileExtension = image.getFileExtension().getExtension();
        this.album = image.getAlbum().getName();
        this.geolocation = image.getGeolocation();
        this.tags = "";
        this.captureDate = image.getCaptureDate();
        this.captureAuthor = image.getCaptureAuthor();
    }

    public UUID getID() {
        return ID;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getAlbum() {
        return album;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public String getTags() {
        return tags;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public String getCaptureAuthor() {
        return captureAuthor;
    }


    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    public void setCaptureAuthor(String captureAuthor) {
        this.captureAuthor = captureAuthor;
    }
}
