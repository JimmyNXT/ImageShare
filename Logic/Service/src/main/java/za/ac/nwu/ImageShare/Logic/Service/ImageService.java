package za.ac.nwu.ImageShare.Logic.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.ImageDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;

@Component
@Service
public interface ImageService {
    ImageDTO uploadImage(UserDTO owner, ImageDTO imageDTO, byte[]fileContent);
}
