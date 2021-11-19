package za.ac.nwu.ImageShare.Domain.Presentation;

import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;

public class UserInformationResponse {
    private String username;
    private String email;

    public UserInformationResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserInformationResponse(UserDTO user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
