package za.ac.nwu.ImageShare.Logic.Service;

import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;

public interface UserService {
    UserDTO addNewUser(UserRegistrationRequest userRegistrationinformation);
    UserDTO getUserDetails(String username);
    UserDTO updateUser(UserDTO oldUser, UserRegistrationRequest userRegistrationInformation);

}
