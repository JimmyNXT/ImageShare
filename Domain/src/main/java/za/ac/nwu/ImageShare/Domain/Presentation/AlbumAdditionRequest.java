package za.ac.nwu.ImageShare.Domain.Presentation;

import java.util.Objects;

public class AlbumAdditionRequest {

    private String albumName;

    public AlbumAdditionRequest() {
    }

    public AlbumAdditionRequest(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumAdditionRequest that = (AlbumAdditionRequest) o;
        return Objects.equals(albumName, that.albumName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumName);
    }

    @Override
    public String toString() {
        return "AlbumAdditionRequest{" +
                "albumName='" + albumName + '\'' +
                '}';
    }
}
