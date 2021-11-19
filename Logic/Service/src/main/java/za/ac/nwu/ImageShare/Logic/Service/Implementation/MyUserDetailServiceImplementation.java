package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Logic.Service.MyUserDetailService;

@Service
@Component
public class MyUserDetailServiceImplementation implements MyUserDetailService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDTO(username);
    }
}
