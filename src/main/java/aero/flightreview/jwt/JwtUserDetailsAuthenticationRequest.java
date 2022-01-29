package aero.flightreview.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtUserDetailsAuthenticationRequest {
    private String username;
    private String password;
}
