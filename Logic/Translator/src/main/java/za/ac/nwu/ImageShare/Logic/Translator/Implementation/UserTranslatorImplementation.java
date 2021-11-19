package za.ac.nwu.ImageShare.Logic.Translator.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiDatabaseException;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;
import za.ac.nwu.ImageShare.Persistence.Repository.UserRepository;

import java.util.UUID;

@Component
public class UserTranslatorImplementation implements UserTranslator {
    private final UserRepository userRepository;

    @Autowired
    public UserTranslatorImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByUsername(String username){
        return new UserDTO(userRepository.getByUsername(username));
    }

    public UserDTO getUserById(UUID userID){
        return new UserDTO(userRepository.getById(userID));
    }

    public UserDTO addUser(UserDTO inUser){
        try {
            User user = userRepository.save(inUser.getUser());
            return new UserDTO(user);
        }catch (Exception e){
            throw new ApiDatabaseException("Unable to save user to database");
        }
    }

    public boolean isUniqueEmail(String email){
        //TODO : Check that email is unique
        return true;
    }

    public boolean isUniqueUsername(String username){
        //TODO : Check that username is unique
        return true;
    }
}
