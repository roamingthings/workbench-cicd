package de.roamingthings.workbench.cicd;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class PingST {

    @Test
    public void should_get_pong_response() {
        when().
                get("/ping").
                then().
                statusCode(200).
                body(is("pong"));
    }
}
