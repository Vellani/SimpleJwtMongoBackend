package aero.flightreview.config;

import aero.flightreview.web.interceptor.SimpleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public final SimpleInterceptor simpleInterceptor;

    public WebConfiguration(SimpleInterceptor simpleInterceptor) {
        this.simpleInterceptor = simpleInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor);
    }
}
