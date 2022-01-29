package aero.flightreview.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;

@ConfigurationProperties(prefix = "application.jwt")
@NoArgsConstructor
@Data
public class JwtConfiguration {

    private String secret;
    private String tokenPrefix;
    private Integer tokenExpiration;


    @Bean
    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(this.secret.getBytes());
    }

    public String getAuthorization() {
        return HttpHeaders.AUTHORIZATION;
    }
}
