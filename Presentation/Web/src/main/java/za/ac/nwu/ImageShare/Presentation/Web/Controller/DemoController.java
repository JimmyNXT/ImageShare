package za.ac.nwu.ImageShare.Presentation.Web.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController(value = "/api/demo")
public class DemoController {

    @GetMapping("/home")
    public String home(Authentication authentication){
        return ("<h1>Welcome " + authentication.getName() + "</h1>");
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
