package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Domain.Exception.ApiUserException;
import za.ac.nwu.ImageShare.Domain.Presentation.UserAuthenticationRequest;
import za.ac.nwu.ImageShare.Domain.Presentation.UserAuthenticationResponse;
import za.ac.nwu.ImageShare.Domain.Presentation.UserRegistrationRequest;
import za.ac.nwu.ImageShare.Logic.Service.MyUserDetailService;
import za.ac.nwu.ImageShare.Logic.Service.UserService;
import za.ac.nwu.ImageShare.Presentation.Web.Utility.JwtUtility;

@RestController
@RequestMapping(("/auth"))
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailService;
    private final JwtUtility jwtUtility;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, MyUserDetailService userDetailService, JwtUtility jwtUtility, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtility = jwtUtility;
        this.userService = userService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserAuthenticationRequest userAuthenticationRequest) {
        System.out.println();
        System.out.println(userAuthenticationRequest.toString());
        System.out.println();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthenticationRequest.getUsername(), userAuthenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new ApiUserException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailService
                .loadUserByUsername(userAuthenticationRequest.getUsername());

        final String jwt = jwtUtility.generateToken(userDetails);

        return ResponseEntity.ok(new UserAuthenticationResponse(jwt));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegistrationRequest registrationRequest){
        userService.addNewUser(registrationRequest);
        return ResponseEntity.ok("");
    }
}
