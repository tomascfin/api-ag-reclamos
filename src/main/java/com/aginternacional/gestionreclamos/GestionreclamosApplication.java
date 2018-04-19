package com.aginternacional.gestionreclamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.aginternacional.gestionreclamos.repository")
@EntityScan("com.aginternacional.gestionreclamos.domain")
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class})
@ComponentScan({ "com.aginternacional.gestionreclamos"})
public class GestionreclamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionreclamosApplication.class, args);
	}
}
