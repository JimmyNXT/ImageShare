package za.ac.nwu.ImageShare.Logic.Translator.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;
import za.ac.nwu.ImageShare.Persistence.Repository.UserRepository;

public class UserTranslatorImplementation implements UserTranslator {
    private final UserRepository userRepository;

    @Autowired
    public UserTranslatorImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByUsername(String username){
        return null;
    }


}
