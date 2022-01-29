package aero.flightreview.config.userdetails;


import aero.flightreview.database.model.document.UserDoc;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class MongoDBUserDetails extends User {


    public MongoDBUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MongoDBUserDetails(UserDoc user, List<SimpleGrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
    }
}
