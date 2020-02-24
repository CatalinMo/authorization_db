package ro.fortech.AuthorizationServer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import ro.fortech.AuthorizationServer.entity.Authorities;
import ro.fortech.AuthorizationServer.entity.Users;
import ro.fortech.AuthorizationServer.entity.UsersRepository;


@EnableAuthorizationServer
@SpringBootApplication
public class AuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(UsersRepository repository) {
		return (args) -> {
			repository.save(new Users("catalin", "{noop}1234", true, new Authorities("catalin","USER")));
		};
	}
}
