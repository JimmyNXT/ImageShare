package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiUserException;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;
import za.ac.nwu.ImageShare.Logic.Service.UserService;
import za.ac.nwu.ImageShare.Logic.Service.Validator.EmailValidator;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;

@Service
@Component
public class UserServiceImplementation implements UserService {
    private final UserTranslator userTranslator;
    private final EmailValidator emailValidator;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserServiceImplementation(UserTranslator userTranslator, EmailValidator emailValidator, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userTranslator = userTranslator;
        this.emailValidator = emailValidator;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public UserDTO addNewUser(UserRegistrationRequest userRegistrationinformation) {
        String password = passwordEncoder.encode(userRegistrationinformation.getPassword());

        UserDTO newUser = new UserDTO(
                userRegistrationinformation.getUsername(),
                userRegistrationinformation.getEmail(),
                password,
                true);

        if (!userTranslator.isUniqueUsername(newUser.getUsername())) {
            throw new ApiUserException("Username is already taken");
        }

        if (!userTranslator.isUniqueEmail(newUser.getEmail())) {
            throw new ApiUserException("Email is already in use");
        }

        if (!emailValidator.test(newUser.getEmail())) {
            throw new ApiUserException("Must be a valid email");
        }

        return userTranslator.addUser(newUser);
    }

    public UserDTO getUserDetails(String username) {
        return userTranslator.getUserByUsername(username);
    }

    public UserDTO updateUser(UserDTO oldUser, UserRegistrationRequest userRegistrationInformation) {
        User userDetails = (User) userDetailsService.loadUserByUsername(oldUser.getUsername());
        String newPassword = userRegistrationInformation.getPassword();
        String password = "";

        if (newPassword.length() == 0) {
            password = userDetails.getPassword();
        } else {
            password = passwordEncoder.encode(userRegistrationInformation.getPassword());
        }

        UserDTO newUser = new UserDTO(
                userRegistrationInformation.getUsername(),
                userRegistrationInformation.getEmail(),
                password,
                true);
        return userTranslator.updateUser(userDetails.getID(), newUser);
    }
}
