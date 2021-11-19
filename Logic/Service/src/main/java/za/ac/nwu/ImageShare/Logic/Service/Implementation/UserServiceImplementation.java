package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiUserException;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;
import za.ac.nwu.ImageShare.Logic.Service.UserService;
import za.ac.nwu.ImageShare.Logic.Service.Validator.EmailValidator;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;

@Service
@Component
public class UserServiceImplementation implements UserService {
    private final UserTranslator userTranslator;
    private final EmailValidator emailValidator;

    @Autowired
    public UserServiceImplementation(UserTranslator userTranslator, EmailValidator emailValidator) {
        this.userTranslator = userTranslator;
        this.emailValidator = emailValidator;
    }

    public UserDTO addNewUser(UserRegistrationRequest userRegistrationinformation) {
        UserDTO newUser = new UserDTO(userRegistrationinformation.getUsername(), userRegistrationinformation.getEmail(), userRegistrationinformation.getPassword(), true);

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
}
