package za.ac.nwu.ImageShare.Logic.Translator;

import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;

import java.util.UUID;

public interface UserTranslator {
    UserDTO getUserByUsername(String username);
    UserDTO addUser(UserDTO inUser);
    boolean isUniqueEmail(String email);
    boolean isUniqueUsername(String username);
    UserDTO updateUser(UUID oldUserID, UserDTO inUser);
}
