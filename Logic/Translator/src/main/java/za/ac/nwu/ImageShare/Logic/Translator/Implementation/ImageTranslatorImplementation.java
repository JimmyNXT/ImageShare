package za.ac.nwu.ImageShare.Logic.Translator.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ImageShare.Domain.DataTransfer.ImageDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiDatabaseException;
import za.ac.nwu.ImageShare.Domain.Persistence.Album;
import za.ac.nwu.ImageShare.Domain.Persistence.FileExtension;
import za.ac.nwu.ImageShare.Domain.Persistence.Image;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Logic.Translator.ImageTranslator;
import za.ac.nwu.ImageShare.Persistence.FileStorage.FileStorage;
import za.ac.nwu.ImageShare.Persistence.Repository.AlbumRepository;
import za.ac.nwu.ImageShare.Persistence.Repository.FileExtensionRepository;
import za.ac.nwu.ImageShare.Persistence.Repository.ImageRepository;
import za.ac.nwu.ImageShare.Persistence.Repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.Collections;

@Component
public class ImageTranslatorImplementation implements ImageTranslator {

    private final FileStorage fileStorage;
    private final UserRepository userRepository;
    private final AlbumRepository albumRepository;
    private final FileExtensionRepository fileExtensionRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public ImageTranslatorImplementation(FileStorage fileStorage, UserRepository userRepository, AlbumRepository albumRepository, FileExtensionRepository fileExtensionRepository, ImageRepository imageRepository) {
        this.fileStorage = fileStorage;
        this.userRepository = userRepository;
        this.albumRepository = albumRepository;
        this.fileExtensionRepository = fileExtensionRepository;
        this.imageRepository = imageRepository;
    }

    public ImageDTO uploadImage(UserDTO userDTO, ImageDTO imageDTO, byte[] fileContent){
        try {
            User owner = userRepository.getByUsername(userDTO.getUsername());
            Album album = albumRepository.findByNameAndOwner(imageDTO.getAlbum(), owner);
            FileExtension fileExtension = fileExtensionRepository.findByExtension(imageDTO.getFileExtension());

            Image image = new Image(imageDTO.getFilename(), fileExtension, album, imageDTO.getGeolocation(), Collections.emptySet(), imageDTO.getCaptureDate(), imageDTO.getCaptureAuthor(), ZonedDateTime.now(), Collections.emptySet());

            Image newImage = imageRepository.save(image);

            fileStorage.uploadFile(newImage.getID(), fileContent);

            return new ImageDTO(newImage);
        }catch (Exception e){
            throw new ApiDatabaseException("Failed to save image");
        }
    }
}
