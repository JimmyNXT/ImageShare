package za.ac.nwu.ImageShare.Domain.Presentation;

import java.util.Objects;

public class AlbumShareRequest {
    private String username;
    private String albumName;

    public AlbumShareRequest(String username, String albumName) {
        this.username = username;
        this.albumName = albumName;
    }

    public String getUsername() {
        return username;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumShareRequest that = (AlbumShareRequest) o;
        return Objects.equals(username, that.username) && Objects.equals(albumName, that.albumName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, albumName);
    }

    @Override
    public String toString() {
        return "AlbumShareRequest{" +
                "username='" + username + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
