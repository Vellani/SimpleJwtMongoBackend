package aero.flightreview.config;

import aero.flightreview.config.userdetails.MongoDBUserDetailsService;
import aero.flightreview.jwt.JwtConfiguration;
import aero.flightreview.jwt.JwtTokenVerifier;
import aero.flightreview.jwt.JwtUserDetailsAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MongoDBUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfiguration jwtConfiguration;

    public ApplicationSecurityConfiguration(MongoDBUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtConfiguration jwtConfiguration) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtConfiguration = jwtConfiguration;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUserDetailsAuthenticationFilter(authenticationManager(), jwtConfiguration))
                .addFilterAfter(new JwtTokenVerifier(jwtConfiguration), JwtUserDetailsAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


}
