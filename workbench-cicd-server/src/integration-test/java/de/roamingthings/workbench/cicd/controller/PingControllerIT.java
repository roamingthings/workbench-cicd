package de.roamingthings.workbench.cicd.controller;

import de.roamingthings.workbench.cicd.CiCdWorkbenchApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


/**
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/06/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CiCdWorkbenchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PingControllerIT {
    private static final String HOST = "http://localhost";

    @Value("${local.server.port}")
    private int port;

    private String baseURI;

    @Before
    public void setup() {
        baseURI = HOST + ":" + port;
    }

    @Test
    public void should_response_pong() {
        // @formatter:off
        given().log().all()
            .when()
                .get(baseURI + "/ping").prettyPeek()
            .then()
                .statusCode(200)
            .and()
                .body(is("pong"));
        // @formatter:on

    }

}
