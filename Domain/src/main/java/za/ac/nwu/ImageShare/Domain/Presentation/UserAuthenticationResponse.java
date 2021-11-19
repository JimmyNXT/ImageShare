package za.ac.nwu.ImageShare.Domain.Presentation;

import java.io.Serializable;

public class UserAuthenticationResponse implements Serializable {
    private final String jwt;

    public UserAuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
