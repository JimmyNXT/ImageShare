package za.ac.nwu.ImageShare.Logic.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ImageShare.Logic.Service.MyUserDetailService;
import za.ac.nwu.ImageShare.Logic.Service.Validator.EmailValidator;
import za.ac.nwu.ImageShare.Logic.Translator.UserTranslator;

@Service
@Component
public class MyUserDetailServiceImplementation implements MyUserDetailService {
    private final UserTranslator userTranslator;
    private final EmailValidator emailValidator;

    @Autowired
    public MyUserDetailServiceImplementation(UserTranslator userTranslator, EmailValidator emailValidator) {
        this.userTranslator = userTranslator;
        this.emailValidator = emailValidator;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userTranslator.getUserByUsername(username);
    }
}
