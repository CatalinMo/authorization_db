package ro.fortech.AuthorizationServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("first-client")
                .secret(passwordEncoder().encode("noonewilleverguess"))
                .scopes("resource:read")
                .authorizedGrantTypes("authorization_code")
                .redirectUris("http://facebook.com");
    }
}