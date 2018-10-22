package es.apinazo.booter.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Listens to {@link ApplicationEnvironmentPreparedEvent}.
 *
 * This is sent when the Environment to be used in the context is known but before the context is created.
 *
 * Therefore this cannot be a bean nor @{@link Autowired} since there is yet no
 * context when this event is triggered.
 *
 * In order to catch it, it must be added to the SpringApplication instance with addListeners(...)
 * when it is built in the main(), or to the META-INF/spring.factories file.
 *
 * @see <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-application-events-and-listeners">Application events and listeners</a>
 */
@Slf4j
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        log.info("[EVENTS] Caught ApplicationEnvironmentPreparedEvent");
    }
}
