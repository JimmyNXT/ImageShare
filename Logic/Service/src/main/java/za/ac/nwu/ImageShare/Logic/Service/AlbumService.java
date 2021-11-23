package za.ac.nwu.ImageShare.Logic.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AlbumDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumAdditionRequest;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumShareRequest;

import java.util.Set;

public interface AlbumService {
    AlbumDTO addAlbum(UserDTO user, AlbumAdditionRequest albumAdditionRequest);

    Set<AlbumDTO> getUsersAlbums(UserDTO user);

    AlbumDTO shareAlbum(UserDTO owner, AlbumShareRequest albumShareRequest);
}
