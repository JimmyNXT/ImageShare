package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.ImageDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.ImageUploadRequest;
import za.ac.nwu.ImageShare.Logic.Service.ImageService;

@Component
@Service
public class ImageServiceImplementation implements ImageService {
    public ImageDTO uploadImage(UserDTO owner, ImageDTO imageDTO, byte[] fileContent){
        return null;
    }
}
