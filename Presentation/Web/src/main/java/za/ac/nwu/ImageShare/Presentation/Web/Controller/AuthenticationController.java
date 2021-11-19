package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AuthenticationRequestDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.AuthenticationResponseDTO;
import za.ac.nwu.ImageShare.Domain.DataTransfer.RegistrationRequestDTO;
import za.ac.nwu.ImageShare.Logic.Service.MyUserDetailService;
import za.ac.nwu.ImageShare.Presentation.Web.Utility.JwtUtility;

@RestController(value = "/api/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailService;
    private final JwtUtility jwtUtility;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, MyUserDetailService userDetailService, JwtUtility jwtUtility) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtility = jwtUtility;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authenticationRequestDTO.getUsername());

        final String jwt = jwtUtility.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
    }

    @PostMapping(value = "/register", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> registerNewUser(@RequestBody RegistrationRequestDTO registrationRequest){
        System.out.println(registrationRequest.toString());
        return ResponseEntity.ok("test");
    }

//    @RequestMapping(value="register", method = RequestMethod.OPTIONS)
//    public ResponseEntity<?> registerNewUserOptions(){
//        return ResponseEntity.ok().allow(HttpMethod.POST).build();
//    }

}
