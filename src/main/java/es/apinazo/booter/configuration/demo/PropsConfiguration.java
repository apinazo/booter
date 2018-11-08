package es.apinazo.booter.configuration.demo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Example of auto binding properties from configuration files into a class.
 *
 * @{@link Configuration} tells Spring this a configuration class,
 * so it be loaded before the other beans.
 *
 * @{@link ConfigurationProperties} makes Spring look for values in the properties files
 * and auto inject them in this class fields, following a pattern matching by name.
 *
 * The string "props" - the prefix - says where to look for properties hierarchically
 * in the tree of all the configuration properties.
 *
 * @{@link Validated} triggers validation of class properties, where validations are defined.
 *
 * For injecting to work, all fields must have a setter method.
 *
 * See application.properties to find the properties used in this example.
 */
@Data
@Slf4j
@ToString
@Validated
@Configuration
@ConfigurationProperties("props")
public class PropsConfiguration {

    String name;

    String randomString;

    String uuid;

    String propFromAnother;

    @NotNull // This makes this prop mandatory if the configuration is @Validated.
    String notNullableProp;

    int number;

    int numberBelowAnother;

    int numberBetweenTwoValues;

    boolean enabled;

    String[] arrayOfThings;

    String[] anotherArrayOfThings;

    List<String> listOfThings;

    Map<String, String> mapOfThings;

    NestedConf firstNestedConf;

    NestedConf secondNestedConf;

    NestedConf[] nestedConfArray;

    /**
     * You can use inner classes to map complex properties or to create a hierarchy
     * of nested configurations.
     */
    @Data
    public static class NestedConf {

        private String key;

        private String value;
    }

    @PostConstruct
    public void init(){
        log.info("PropsConfiguration initialized with values: {}", this);
    }

}
