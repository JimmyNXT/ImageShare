package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AlbumDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Persistence.User;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumAdditionRequest;
import za.ac.nwu.ImageShare.Domain.Presentation.AlbumShareRequest;
import za.ac.nwu.ImageShare.Logic.Service.AlbumService;
import za.ac.nwu.ImageShare.Logic.Service.UserService;

@RestController
@RequestMapping("/api/album")
public class AlbumController {
    private final AlbumService albumService;
    private final UserService userService;

    @Autowired
    public AlbumController(AlbumService albumService, UserService userService) {
        this.albumService = albumService;
        this.userService = userService;
    }

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<?> getAlbums(Authentication authentication){
        UserDTO user = userService.getUserDetails(authentication.getName());
        return ResponseEntity.ok(albumService.getUsersAlbums(user));
    }

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<?> addAlbums(Authentication authentication, @RequestBody AlbumAdditionRequest albumAdditionRequest){

        UserDTO user = userService.getUserDetails(authentication.getName());
        AlbumDTO album = albumService.addAlbum(user, albumAdditionRequest);
        return ResponseEntity.ok(album);
    }

    @CrossOrigin("*")
    @PostMapping("/share")
    public ResponseEntity<?> shareAlbum(Authentication authentication, @RequestBody AlbumShareRequest albumShareRequest){
        UserDTO user = userService.getUserDetails(authentication.getName());
        AlbumDTO album = albumService.shareAlbum(user, albumShareRequest);
        return ResponseEntity.ok(album);
    }

    @CrossOrigin("*")
    @GetMapping("/{albumName}")
    public ResponseEntity<?> getAlbumImages(Authentication authentication,@PathVariable String albumName){
        UserDTO user = userService.getUserDetails(authentication.getName());
        return null;
    }

}
