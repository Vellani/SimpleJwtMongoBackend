package aero.flightreview;

import aero.flightreview.jwt.JwtConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMongoAuditing
@EnableConfigurationProperties({JwtConfiguration.class})
public class SimpleJwtMongoBackend {


	public static void main(String[] args) {
		SpringApplication.run(SimpleJwtMongoBackend.class, args);
	}

}
