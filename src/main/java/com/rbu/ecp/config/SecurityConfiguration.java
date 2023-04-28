package com.rbu.ecp.config;


import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //protect endpoint /api/orders
        http.authorizeRequests(configurer ->
                   configurer
                           .antMatchers("/api/orders/**")
                           .authenticated())
                .oauth2ResourceServer()
                .jwt();

        //add cors filters
        http.cors();

        //add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                              new HeaderContentNegotiationStrategy());

        //force a non-empty response body for 401's to make the response user friendly
        Okta.configureResourceServer401ResponseBody(http);

        //disable CSRF since we are not usign cookies for session tracking
        http.csrf().disable();

        return http.build();  //HttpSecurity supports the Builder design pattern hence, we can "build it" to return the instance

    }
}
