package dev.sun.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dev.sun.entities") // will allow spring to find your entities
@ComponentScan("dev.sun") // please scan all packages and any class labled with componenet incorporate in to the Spring application
@EnableJpaRepositories("dev.sun.repositories") // Telling spring where to find my repositories
public class TheSunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheSunApplication.class, args);
	}

}
