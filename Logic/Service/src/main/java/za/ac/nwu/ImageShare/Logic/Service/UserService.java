package za.ac.nwu.ImageShare.Logic.Service;

import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;

public interface UserService {
    UserDTO addNewUser(UserRegistrationRequest userRegistrationinformation);
}
