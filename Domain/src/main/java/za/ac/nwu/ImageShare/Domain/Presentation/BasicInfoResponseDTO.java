package za.ac.nwu.ImageShare.Domain.Presentation;

import java.io.Serializable;

public class BasicInfoResponseDTO implements Serializable {
    private String info;

    public BasicInfoResponseDTO(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
