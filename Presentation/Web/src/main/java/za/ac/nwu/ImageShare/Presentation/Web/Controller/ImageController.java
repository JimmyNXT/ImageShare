package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import za.ac.nwu.ImageShare.Domain.DataTransfer.ImageDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.ImageUploadRequest;
import za.ac.nwu.ImageShare.Logic.Service.ImageService;
import za.ac.nwu.ImageShare.Logic.Service.UserService;
import org.apache.commons.io.FilenameUtils;

import java.util.Optional;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;
    private final UserService userService;

    @Autowired
    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(Authentication authentication, @RequestParam CommonsMultipartFile file, @RequestBody ImageUploadRequest imageUploadRequest){
        UserDTO user = userService.getUserDetails(authentication.getName());
        ImageDTO imageDTO = new ImageDTO(file.getName(),FilenameUtils.getExtension(file.getName()), imageUploadRequest.getAlbum(), imageUploadRequest.getGeolocation(), "", imageUploadRequest.getCaptureDate(), imageUploadRequest.getCaptureAuthor());
        file.getBytes();
        return ResponseEntity.ok(imageService.uploadImage(user,imageDTO, file.getBytes()));
    }
}
