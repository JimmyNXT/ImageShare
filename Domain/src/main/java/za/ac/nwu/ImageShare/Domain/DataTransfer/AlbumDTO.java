package za.ac.nwu.ImageShare.Domain.DataTransfer;

import za.ac.nwu.ImageShare.Domain.Persistence.Album;

import java.io.Serializable;
import java.util.Objects;

public class AlbumDTO  implements Serializable {
    private String name;
    private String owner;

    public AlbumDTO() {
    }

    public AlbumDTO(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public AlbumDTO(Album album) {
        this.name = album.getName();
        this.owner = album.getOwner().getUserName();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
