package aero.flightreview.config.userdetails;

import aero.flightreview.database.model.document.UserDoc;
import aero.flightreview.database.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MongoDBUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MongoDBUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public MongoDBUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDoc user = userService.findByUsername(username);

        if(user.getRoles() != null) {

            List<SimpleGrantedAuthority> authorities =
                    user.getRoles().stream().map(e -> new SimpleGrantedAuthority("ROLE_" + e)).collect(Collectors.toUnmodifiableList());

            return new MongoDBUserDetails(user, authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
