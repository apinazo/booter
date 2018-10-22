package es.apinazo.booter;

import es.apinazo.booter.events.ApplicationEnvironmentPreparedEventListener;
import es.apinazo.booter.events.ApplicationStartingEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Sample Spring Boot app.
 *
 * This class will start the Spring Boot Application.
 * Also is a good candidate as the primary @Configuration.
 *
 * @{@link SpringBootApplication} equals to @Configuration, @EnableAutoConfiguration and @ComponentScan.
 * @{@link @{@link ComponentScan} will scan all packages here and below.
 */
@SpringBootApplication
public class BooterApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(BooterApplication.class);

		// Add listeners which must be set before the context is ready.
		// Alternatively they can be added to META-INF/spring.factories file.
		// That file contains an example.
		app.addListeners(
			new ApplicationStartingEventListener(),
			new ApplicationEnvironmentPreparedEventListener());

		// And run the app!
		app.run(args);
	}
}
