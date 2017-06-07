package io.resourcepool.nextreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "io.resourcepool.nextreview.persistence")
@SpringBootApplication
public class NextreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextreviewApplication.class, args);
	}
	
}
