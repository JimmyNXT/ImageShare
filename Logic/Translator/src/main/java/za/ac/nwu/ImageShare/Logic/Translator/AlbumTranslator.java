package za.ac.nwu.ImageShare.Logic.Translator;

import za.ac.nwu.ImageShare.Domain.DataTransfer.AlbumDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumShareRequest;

import java.util.Set;

public interface AlbumTranslator {
    Set<AlbumDTO> getUsersAlbums(UserDTO userDTO);

    AlbumDTO addAlbum(UserDTO user, String albumName);

    AlbumDTO shareAlbum(UserDTO owner, AlbumShareRequest albumShareRequest);
}
