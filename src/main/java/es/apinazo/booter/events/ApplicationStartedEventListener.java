package es.apinazo.booter.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Listens to {@link ApplicationStartedEvent}.
 *
 * This event is sent after the context has been refreshed but before any application and command-line runners have been called.
 * In this point, the app has started but it's not ready yet to service requests.
 *
 * Here we could implement a check to test if another services used by this one are available,
 * before being ready to service requests.
 *
 * When the event is triggered, context is ready so the listener can be a @{@link Bean}.
 *
 * @see <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-application-events-and-listeners">Application events and listeners</a>
 */
@Slf4j
@Component
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("[EVENTS] Caught ApplicationStartedEvent");
    }
}
