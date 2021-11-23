package za.ac.nwu.ImageShare.Logic.Translator.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AlbumDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiDatabaseException;
import za.ac.nwu.ImageShare.Domain.Persistence.Album;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumShareRequest;
import za.ac.nwu.ImageShare.Logic.Translator.AlbumTranslator;
import za.ac.nwu.ImageShare.Persistence.Repository.AlbumRepository;
import za.ac.nwu.ImageShare.Persistence.Repository.UserRepository;

import java.util.*;

@Component
public class AlbumTranslatorImplementation implements AlbumTranslator {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    @Autowired
    public AlbumTranslatorImplementation(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<AlbumDTO> getUsersAlbums(UserDTO userDTO) {
        User user = userRepository.getByUsername(userDTO.getUsername());
        Set<Album> albums = albumRepository.findByOwner(user);

        Set<AlbumDTO> albumDTOs = new HashSet<AlbumDTO>();

        for (Album a : albums) {
            albumDTOs.add(new AlbumDTO(a));
        }

        albumDTOs.add(new AlbumDTO("Shared with me", user.getUserName()));
        albumDTOs.add(new AlbumDTO("Shared with me", user.getUserName()));

        return albumDTOs;
    }

    @Override
    public AlbumDTO addAlbum(UserDTO userDTO, String albumName) {
        try {
            User user = userRepository.getByUsername(userDTO.getUsername());
            Album newAlbum = new Album(albumName, user, Collections.emptySet(), Collections.emptySet());
            return new AlbumDTO(albumRepository.save(newAlbum));
        } catch (Exception e) {
            throw new ApiDatabaseException("Unable to save Album to database");
        }
    }

    @Override
    public AlbumDTO shareAlbum(UserDTO ownerDTO, AlbumShareRequest albumShareRequest) {
        try {
            User owner = userRepository.getByUsername(ownerDTO.getUsername());
            User sharedUser = userRepository.getByUsername(albumShareRequest.getUsername());
            Album sharedAlbum = albumRepository.findByNameAndOwner(albumShareRequest.getAlbumName(), owner);
            Set<User> sharedUsers = sharedAlbum.getSharedWithUsers();
            sharedUsers.add(sharedUser);
            sharedAlbum.setSharedWithUsers(sharedUsers);
            return new AlbumDTO(albumRepository.save(sharedAlbum));
        } catch (Exception e) {
            throw new ApiDatabaseException("Unable to save Album to database");
        }
    }
}
