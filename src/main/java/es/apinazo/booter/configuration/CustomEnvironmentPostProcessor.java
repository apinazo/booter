package es.apinazo.booter.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import org.springframework.context.ApplicationContext;

/**
 * This an example of a {@link EnvironmentPostProcessor} that will customize
 * the {@link ApplicationContext} before it starts.
 *
 * This processor must be registered in the spring.factories file since it
 * will be configured before the context is available.
 *
 * Loads extra configuration from the extra-config.yml file.
 * Application start will fail if that file is not found.
 */
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    // Loads a configuration from a yml file.
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    private final String configFileName = "extra-config.yml";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        // Load the yml file.
        Resource path = new ClassPathResource(configFileName);

        // Get all its properties.
        PropertySource<?> propertySource = loadYml(path);

        // Add them all to the environment.
        environment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<?> loadYml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            // Load the file and give the resource the prefix custom-resource.
            return this.loader.load("custom-resource", path).get(0);
        }
        catch (IOException ex) {
            throw new IllegalStateException(
                    "Failed to load yml configuration from " + path, ex);
        }
    }

}
