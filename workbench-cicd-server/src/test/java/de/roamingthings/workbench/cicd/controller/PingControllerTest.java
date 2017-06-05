package de.roamingthings.workbench.cicd.controller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PingControllerTest {
    @Test
    public void should_return_pong() throws Exception {
        PingController pingController = new PingController();

        ResponseEntity pingResponse = pingController.ping();
        assertThat(pingResponse.getBody(), is("pong"));
    }

    @Test
    public void should_return_greeting() throws Exception {
        PingController pingController = new PingController();

        ResponseEntity pingResponse = pingController.greeting("world!");
        assertThat(pingResponse.getBody(), is("Hello world!"));
    }

}