package za.ac.nwu.ImageShare.Domain.DataTransfer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.ac.nwu.ImageShare.Domain.Persistence.Image;
import za.ac.nwu.ImageShare.Domain.Persistence.User;

import java.util.*;

public class UserDTO implements UserDetails {

    private String username;
    private String email;
    private String password;
    private boolean isActive;

    public UserDTO(String username, String email, String password, boolean isActive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public UserDTO(User user) {
        this.username = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.isActive = user.isActive();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    public User getUser(){
        return new User(this.username, this.password, this.email, this.isActive, Collections.EMPTY_SET);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return isActive == userDTO.isActive && Objects.equals(username, userDTO.username) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, isActive);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
