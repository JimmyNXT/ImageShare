package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Domain.DataTransfer.UserDTO;
import za.ac.nwu.ImageShare.Logic.Service.MyUserDetailService;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;

@Service
@Component
public class MyUserDetailServiceImplementation implements MyUserDetailService {
    private final UserTranslator userTranslator;

    @Autowired
    public MyUserDetailServiceImplementation(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userTranslator.getUserByUsername(username);
    }
}
