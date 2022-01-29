package aero.flightreview.database.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDoc {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;

//    @DocumentReference(lazy = true)
//    private Set<ReviewDoc> reviews;

}
