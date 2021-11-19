package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ImageShare.Domain.Presentation.BasicInfoResponseDTO;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping
    public ResponseEntity<?> getUserData(Authentication authentication){
        return ResponseEntity.ok(new BasicInfoResponseDTO(authentication.getName()));
    }
}
