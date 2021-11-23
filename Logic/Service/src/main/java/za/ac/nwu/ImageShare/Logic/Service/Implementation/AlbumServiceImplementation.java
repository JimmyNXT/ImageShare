package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AlbumDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumAdditionRequest;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumShareRequest;
import za.ac.nwu.ImageShare.Logic.Service.AlbumService;
import za.ac.nwu.ImageShare.Logic.Translator.AlbumTranslator;

import java.util.Set;

@Service
@Component
public class AlbumServiceImplementation implements AlbumService {

    private final AlbumTranslator albumTranslator;

    @Autowired
    public AlbumServiceImplementation(AlbumTranslator albumTranslator) {
        this.albumTranslator = albumTranslator;
    }

    @Override
    public AlbumDTO addAlbum(UserDTO user, AlbumAdditionRequest albumAdditionRequest) {
        return albumTranslator.addAlbum(user, albumAdditionRequest.getAlbumName());
    }

    public Set<AlbumDTO> getUsersAlbums(UserDTO userDTO){
        Set<AlbumDTO> albumDTOSet = albumTranslator.getUsersAlbums(userDTO);
        return albumDTOSet;
    }

    @Override
    public AlbumDTO shareAlbum(UserDTO owner, AlbumShareRequest albumShareRequest) {
        return albumTranslator.shareAlbum(owner, albumShareRequest);
    }
}
