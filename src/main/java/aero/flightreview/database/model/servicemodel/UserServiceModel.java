package aero.flightreview.database.model.servicemodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserServiceModel {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;

    /**
    * For Debug we need to create the roles
     */
    @NotNull
    private Set<String> roles;

}
