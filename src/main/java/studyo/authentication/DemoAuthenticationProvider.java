package studyo.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {

    // This would be a JPA repository to snag your user entities
    //private final UserRepository userRepository;
    
   /* @Autowired
    public DemoAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }  */  
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        //DemoAuthenticationToken demoAuthentication = (DemoAuthenticationToken) authentication;        
        //User user = userRepository.find(demoAuthentication.getId());
        System.out.println("Autenticado! TESTE");
        //if(user == null){
        //    throw new UnknownUserException("Could not find user with ID: " + demoAuthentication.getId());
        //}
        authentication.setAuthenticated(true);
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return DemoAuthenticationToken.class.isAssignableFrom(authentication);
    }

}