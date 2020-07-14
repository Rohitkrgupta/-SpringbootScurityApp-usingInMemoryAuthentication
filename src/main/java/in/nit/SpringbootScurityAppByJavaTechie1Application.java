package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringbootScurityAppByJavaTechie1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootScurityAppByJavaTechie1Application.class, args);
	}

}
