package es.apinazo.booter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication equals to @Configuration, @EnableAutoConfiguration and @ComponentScan.
// @ComponentScan will scan all packages from here and below.
@SpringBootApplication
public class BooterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooterApplication.class, args);
	}
}
