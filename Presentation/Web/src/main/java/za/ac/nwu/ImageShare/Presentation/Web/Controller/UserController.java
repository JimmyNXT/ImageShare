package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Presentation.UserInformationResponse;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;
import za.ac.nwu.ImageShare.Logic.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<?> getUserData(Authentication authentication){
        UserDTO user = userService.getUserDetails(authentication.getName());
        return ResponseEntity.ok(new UserInformationResponse(user));
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(Authentication authentication, @RequestBody UserRegistrationRequest registrationRequest){
        System.out.println("User Name : " + authentication.getName());
        UserDTO oldUser = userService.getUserDetails(authentication.getName());
        UserDTO user = userService.updateUser(oldUser, registrationRequest);
        return ResponseEntity.ok(new UserInformationResponse(user));
    }
}
