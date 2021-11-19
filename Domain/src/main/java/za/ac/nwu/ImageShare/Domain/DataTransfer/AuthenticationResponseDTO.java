package za.ac.nwu.ImageShare.Domain.DataTransfer;

import java.io.Serializable;

public class AuthenticationResponseDTO implements Serializable {
    private final String jwt;

    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
