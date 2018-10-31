package es.apinazo.booter.rpc;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Integration {@link SampleRPCService} tests.
 *
 * App must be up and running.
 */
@RunWith(SpringRunner.class)
// Use a free random port on each test execution.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleRPCServiceIntegrationTest {

    // The random generated port.
    @LocalServerPort
    int serverPort;

    private final String userName = "John Doe";

    @Test
    public void testSayHello() {

        // Build the data to send to the service.
        Map<String,Object> payload = new HashMap<>();
        payload.put("id", "0"); // id is mandatory.
        payload.put("method", "sayHello");
        payload.put("params", new ArrayList<>(Arrays.asList(userName)));

        // Do the request.
        given()
            .filter(new RequestLoggingFilter()) // Log request details.
            .filter(new ResponseLoggingFilter()) // Same for response.
            .contentType("application/json")
            .body(payload) // Auto converted to JSON.
        .when()
            .post("http://localhost:" + serverPort + "/rpc/sample")
        .then()
            .statusCode(200)
            .body(containsString(userName));
    }

}
