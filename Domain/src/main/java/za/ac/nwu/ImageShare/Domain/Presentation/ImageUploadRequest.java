package za.ac.nwu.ImageShare.Domain.Presentation;

import java.io.Serializable;
import java.time.LocalDate;

public class ImageUploadRequest implements Serializable {
    private String album;
    private String geolocation;
    private LocalDate captureDate;
    private String captureAuthor;

    public ImageUploadRequest(String album, String geolocation, LocalDate captureDate, String captureAuthor) {
        this.album = album;
        this.geolocation = geolocation;
        this.captureDate = captureDate;
        this.captureAuthor = captureAuthor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    public String getCaptureAuthor() {
        return captureAuthor;
    }

    public void setCaptureAuthor(String captureAuthor) {
        this.captureAuthor = captureAuthor;
    }
}
