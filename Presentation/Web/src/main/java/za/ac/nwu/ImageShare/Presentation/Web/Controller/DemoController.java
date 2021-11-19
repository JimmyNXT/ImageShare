package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ImageShare.Domain.Presentation.BasicInfoResponseDTO;


@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/home")
    public ResponseEntity<?> home(Authentication authentication){
        return ResponseEntity.ok(new BasicInfoResponseDTO("<h1>Welcome " + authentication.getName() + "</h1>"));
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admnin(){
        return ("<h1>Welcome Admin</h1>");
    }
}
